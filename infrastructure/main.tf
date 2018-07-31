provider "azurerm" {}

# Make sure the resource group exists
resource "azurerm_resource_group" "rg" {
  name     = "${var.product}-${var.component}-${var.env}"
  location = "${var.location}"
}

locals {
  ase_name               = "${data.terraform_remote_state.core_apps_compute.ase_name[0]}"
}

module "rmi-batch" {
  source              = "git@github.com:hmcts/moj-module-webapp?ref=master"
  product             = "${var.product}-${var.component}"
  location            = "${var.location}"
  env                 = "${var.env}"
  ilbIp               = "${var.ilbIp}"
  resource_group_name = "${azurerm_resource_group.rg.name}"
  subscription        = "${var.subscription}"
  capacity            = "${var.capacity}"
  common_tags         = "${var.common_tags}"
  
  app_settings = {	
	# db
    SPRING_DATASOURCE_USERNAME = "${module.rmi-database.user_name}"
    SPRING_DATASOURCE_PASSWORD = "${module.rmi-database.postgresql_password}"
    SPRING_DATASOURCE_URL = "jdbc:postgresql://${module.rmi-database.host_name}:${module.rmi-database.postgresql_listen_port}/${module.rmi-database.postgresql_database}?ssl=true"

	

    LOGBACK_REQUIRE_ALERT_LEVEL = false
    LOGBACK_REQUIRE_ERROR_CODE  = false
  }
}

module "rmi-database" {
  source = "git@github.com:hmcts/moj-module-postgres?ref=master"
  product =  "rmi-common"
  location = "${var.location}"
  env = "${var.env}"
  postgresql_user = "${var.postgresql_user}"
  database_name =  "rmi-common"
  sku_name = "GP_Gen5_2"
  sku_tier = "GeneralPurpose"
  storage_mb = "51200"
  common_tags  = "${var.common_tags}"
}


module "key-vault" {
  source              = "git@github.com:hmcts/moj-module-key-vault?ref=master"
  product             = "${var.product}"
  env                 = "${var.env}"
  tenant_id           = "${var.tenant_id}"
  object_id           = "${var.jenkins_AAD_objectId}"
  resource_group_name = "${module.rmi-batch.resource_group_name}" 
  product_group_object_id = "56679aaa-b343-472a-bb46-58bbbfde9c3d"
}

resource "azurerm_key_vault_secret" "POSTGRES-USER" {
  name      = "rmi-POSTGRES-USER"
  value     = "${module.rmi-database.user_name}"
  vault_uri = "${module.key-vault.key_vault_uri}"
}

resource "azurerm_key_vault_secret" "POSTGRES-PASS" {
  name      = "rmi-POSTGRES-PASS"
  value     = "${module.rmi-database.postgresql_password}"
  vault_uri = "${module.key-vault.key_vault_uri}"
}

resource "azurerm_key_vault_secret" "POSTGRES_HOST" {
  name      = "rmi-POSTGRES-HOST"
  value     = "${module.rmi-database.host_name}"
  vault_uri = "${module.key-vault.key_vault_uri}"
}

resource "azurerm_key_vault_secret" "POSTGRES_PORT" {
  name      = "rmi-POSTGRES-PORT"
  value     = "${module.rmi-database.postgresql_listen_port}"
  vault_uri = "${module.key-vault.key_vault_uri}"
}

resource "azurerm_key_vault_secret" "POSTGRES_DATABASE" {
  name      = "rmi-POSTGRES-DATABASE"
  value     = "${module.rmi-database.postgresql_database}"
  vault_uri = "${module.key-vault.key_vault_uri}"
}