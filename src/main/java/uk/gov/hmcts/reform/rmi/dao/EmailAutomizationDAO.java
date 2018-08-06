package uk.gov.hmcts.reform.rmi.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uk.gov.hmcts.reform.rmi.model.BetaCases;
import uk.gov.hmcts.reform.rmi.model.BetaIncident;
import uk.gov.hmcts.reform.rmi.model.CmcCases;
import uk.gov.hmcts.reform.rmi.model.CmcDefence;
import uk.gov.hmcts.reform.rmi.model.CmcJudgement;
import uk.gov.hmcts.reform.rmi.model.DivorceDTO;
import uk.gov.hmcts.reform.rmi.model.PaymentAccountDTO;
import uk.gov.hmcts.reform.rmi.model.PaymentDTO;
import uk.gov.hmcts.reform.rmi.model.ProbateDTO;
import uk.gov.hmcts.reform.rmi.model.ScssDTO;


@Transactional
@Repository
public class EmailAutomizationDAO implements EmailAutomizationDAOImpl {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(EmailAutomizationDAO.class);
	
	@Override
	public 	void cardPaymentFileProcessor(List<PaymentDTO> paymentDTO){
		logger.info("EmailAutomizationDAO::cardPaymentFileProcessor::Start"); 	
		
		  	  
		  String sql = "insert into payment_card (" +
				  								    "id,							service,			paymentGroupReference,		paymentReference,		ccdReference,		caseReference,		paymentCreatedDateTime," + 
				  								    "paymentStatusUpdatedDateTime,	paymentStatus,		paymentChannel,				paymentMethod,			paymentAmount,		siteId,				feeCode,				"+
				  								    "version,						calculatedAmount,	memoLine,					nac,					feeVolume) " +
				  						"values (nextval('payment_card_id_seq'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				  
				  
		  jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
					
			@Override
			public void setValues(PreparedStatement ps, int i) {
				try {			
					ps.setString(1, paymentDTO.get(i).getService());
					ps.setString(2, paymentDTO.get(i).getPaymentGroupReference());
					ps.setString(3, paymentDTO.get(i).getPaymentReference());
					ps.setString(4, paymentDTO.get(i).getCcdReference());
					ps.setString(5, paymentDTO.get(i).getCaseReference());
					ps.setString(6, paymentDTO.get(i).getPaymentCreatedDateTime());
					ps.setString(7, paymentDTO.get(i).getPaymentStatusUpdatedDateTime());
					ps.setString(8, paymentDTO.get(i).getPaymentStatus());
					ps.setString(9, paymentDTO.get(i).getPaymentChannel());
					ps.setString(10, paymentDTO.get(i).getPaymentMethod());
					ps.setDouble(11, paymentDTO.get(i).getPaymentAmount());
					ps.setString(12, paymentDTO.get(i).getSiteId());
					ps.setString(13, paymentDTO.get(i).getFeeCode());
					ps.setString(14, paymentDTO.get(i).getVersion());
					ps.setDouble(15, paymentDTO.get(i).getCalculatedAmount());
					ps.setString(16, paymentDTO.get(i).getMemoLine());
					ps.setString(17, paymentDTO.get(i).getNac());
					ps.setString(18, paymentDTO.get(i).feeVolume);
					
				}catch(SQLException e) {			
					logger.error("EmailAutomizationDAO::cardPaymentFileProcessor::There is some problem in inserting data into table......" + e); 						
				}
				
			}

			@Override
			public int getBatchSize() {
				logger.info("EmailAutomizationDAO::cardPaymentFileProcessor::Total Record inserted::"+ paymentDTO.size()); 	
				return paymentDTO.size();
			}
					
			
		  });
		  logger.info("EmailAutomizationDAO::cardPaymentFileProcessor::End"); 
		}
		
		
	@Override
	public void paymentAccountFileProcessor(List<PaymentAccountDTO>  paymentAccountDTO){
		logger.info("EmailAutomizationDAO::paymentAccountFileProcessor::Start"); 	
		
		  	  
		  String sql = "insert into payment_credit_account (" +
				  								    "id,	service,	paymentGroupReference,	paymentReference,	ccdReference,	caseReference,	organisationName,	customerInternalReference,	pbaNumber, paymentCreatedDateTime," +
				  								    "paymentStatusUpdatedDateTime,	paymentStatus,		paymentChannel,				paymentMethod,			paymentAmount,		siteId,				feeCode, "+
				  								    "version,						calculatedAmount,	memoLine,					nac,					feeVolume) " +
				  								    "values (nextval('payment_card_id_seq'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				  
				  
		  jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
					
			@Override
			public void setValues(PreparedStatement ps, int i) {
				try {			
					ps.setString(1, paymentAccountDTO.get(i).getService());
					ps.setString(2, paymentAccountDTO.get(i).getPaymentGroupReference());
					ps.setString(3, paymentAccountDTO.get(i).getPaymentReference());
					ps.setString(4, paymentAccountDTO.get(i).getCcdReference());
					ps.setString(5, paymentAccountDTO.get(i).getCaseReference());					
					ps.setString(6, paymentAccountDTO.get(i).getOrganisationName());
					ps.setString(7, paymentAccountDTO.get(i).getCustomerInternalReference());
					ps.setString(8, paymentAccountDTO.get(i).getPbaNumber());					
					ps.setString(9, paymentAccountDTO.get(i).getPaymentCreatedDateTime());
					ps.setString(10, paymentAccountDTO.get(i).getPaymentStatusUpdatedDateTime());
					ps.setString(11, paymentAccountDTO.get(i).getPaymentStatus());
					ps.setString(12, paymentAccountDTO.get(i).getPaymentChannel());
					ps.setString(13, paymentAccountDTO.get(i).getPaymentMethod());
					ps.setDouble(14, paymentAccountDTO.get(i).getPaymentAmount());
					ps.setString(15, paymentAccountDTO.get(i).getSiteId());
					ps.setString(16, paymentAccountDTO.get(i).getFeeCode());
					ps.setString(17, paymentAccountDTO.get(i).getVersion());
					ps.setDouble(18, paymentAccountDTO.get(i).getCalculatedAmount());
					ps.setString(19, paymentAccountDTO.get(i).getMemoLine());
					ps.setString(20, paymentAccountDTO.get(i).getNac());
					ps.setString(21, paymentAccountDTO.get(i).feeVolume);
					
				}catch(SQLException e) {			
					logger.error("EmailAutomizationDAO::paymentAccountFileProcessor::There is some problem in inserting data into table......" + e); 						
				}
				
			}

			@Override
			public int getBatchSize() {
				logger.info("EmailAutomizationDAO::paymentAccountFileProcessor::Total Record inserted::"+ paymentAccountDTO.size()); 	
				return paymentAccountDTO.size();
			}
					
			
		  });
		  logger.info("EmailAutomizationDAO::cardPaymentFileProcessor::End"); 
		}
	    
	
	@Override
	public void divorceFileProcessor(List<DivorceDTO>  divorceDTO){
		logger.info("EmailAutomizationDAO::divorceFileProcessor::Start"); 	
		
		  	  
		  String sql = "insert into divorce_data (id,matricDate,matric,request) values (nextval('divorce_id_seq'),?,?,?)";
				  
				  
		  jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
					
			@Override
			public void setValues(PreparedStatement ps, int i) {
				try {			
					ps.setString(1, divorceDTO.get(i).getMatricDate());
					ps.setString(2, divorceDTO.get(i).getMatric());				
					ps.setDouble(3, divorceDTO.get(i).getRequest());
					
				}catch(SQLException e) {			
					logger.error("EmailAutomizationDAO::divorceFileProcessor::There is some problem in inserting data into table......" + e); 						
				}
				
			}

			@Override
			public int getBatchSize() {
				logger.info("EmailAutomizationDAO::divorceFileProcessor::Total Record inserted::"+ divorceDTO.size()); 	
				return divorceDTO.size();
			}
					
			
		  });
		  logger.info("EmailAutomizationDAO::divorceFileProcessor::End"); 
		}
		
	
	@Override
	public void probateFileProcessor(List<ProbateDTO>  probateDTO){
		logger.info("EmailAutomizationDAO::probateFileProcessor::Start"); 	
		
		  	  
		  String sql = "insert into probate_data (id,matricDate,matric,request) values (nextval('probate_id_seq'),?,?,?)";
				  
				  
		  jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
					
			@Override
			public void setValues(PreparedStatement ps, int i) {
				try {			
					ps.setString(1, probateDTO.get(i).getMatricDate());
					ps.setString(2, probateDTO.get(i).getMatric());				
					ps.setDouble(3, probateDTO.get(i).getRequest());
					
				}catch(SQLException e) {			
					logger.error("EmailAutomizationDAO::probateFileProcessor::There is some problem in inserting data into table......" + e); 						
				}
				
			}

			@Override
			public int getBatchSize() {
				logger.info("EmailAutomizationDAO::probateFileProcessor::Total Record inserted::"+ probateDTO.size()); 	
				return probateDTO.size();
			}
					
			
		  });
		  logger.info("EmailAutomizationDAO::probateFileProcessor::End"); 
		}
	
		
	@Override
	public void scssFileProcessor(List<ScssDTO>  scssDTO){
		logger.info("EmailAutomizationDAO::scssFileProcessor::Start"); 	
		
		  	  
		  String sql = "insert into scss_data (id,typeId,caseReference,sms,email,region,benefitType,benefitCode,hearingType,venuName) values (nextval('scss_id_seq'),?,?,?,?,?,?,?,?,?)";
				  
				  
		  jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
					
			@Override
			public void setValues(PreparedStatement ps, int i) {
				try {			
					ps.setString(1, scssDTO.get(i).getTypeId());
					ps.setString(2, scssDTO.get(i).getCaseReference());				
					ps.setString(3, scssDTO.get(i).getSms());
					ps.setString(4, scssDTO.get(i).getEmail());	
					ps.setString(5, scssDTO.get(i).getRegion());
					ps.setString(6, scssDTO.get(i).getBenefitType());	
					ps.setString(7, scssDTO.get(i).getBenefitCode());
					ps.setString(8, scssDTO.get(i).getHearingType());	
					ps.setString(9, scssDTO.get(i).getVenuName());
					
				}catch(SQLException e) {			
					logger.error("EmailAutomizationDAO::scssFileProcessor::There is some problem in inserting data into table......" + e); 						
				}
				
			}

			@Override
			public int getBatchSize() {
				logger.info("EmailAutomizationDAO::scssFileProcessor::Total Record inserted::"+ scssDTO.size()); 	
				return scssDTO.size();
			}
					
			
		  });
		  logger.info("EmailAutomizationDAO::scssFileProcessor::End"); 
		}
	
	@Override
	public void betaIncidentFileProcessor(List<BetaIncident> betaIncident) {
		 logger.info("EmailAutomizationDAO::betaIncidentFileProcessor::Start"); 
		 
		 String sql = "insert into incident_beta (id,priority,incidentState,state,shortDescription,category,subCategory,description,assignmentGroup,thirdPartysupportReference,madeSla,serviceOffering,servicePortfolio, " +
				 							  "service,contactType,createdDateTime,updatedDateTime,resolveTime,resolved) values (nextval('incident_beta_id_seq'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps, int i) {
					try {			
						ps.setString(1, betaIncident.get(i).getPriority());
						ps.setString(2, betaIncident.get(i).getIncidentState());				
						ps.setString(3, betaIncident.get(i).getState());
						ps.setString(4, betaIncident.get(i).getShortDescription());	
						ps.setString(5, betaIncident.get(i).getCategory());
						ps.setString(6, betaIncident.get(i).getSubCategory());	
						ps.setString(7, betaIncident.get(i).getDescription());
						ps.setString(8, betaIncident.get(i).getAssignmentGroup());	
						ps.setString(9, betaIncident.get(i).getThirdPartysupportReference());
						ps.setBoolean(10, betaIncident.get(i).isMadeSla());
						ps.setString(11, betaIncident.get(i).getServiceOffering());
						ps.setString(12, betaIncident.get(i).getServicePortfolio());
						ps.setString(13, betaIncident.get(i).getService());
						ps.setString(14, betaIncident.get(i).getContactType());
						ps.setString(15, betaIncident.get(i).getCreatedDateTime());
						ps.setString(16, betaIncident.get(i).getUpdatedDateTime());						
						ps.setString(17, betaIncident.get(i).getResolveTime());
						ps.setString(18, betaIncident.get(i).getResolved());
						
					}catch(SQLException e) {			
						logger.error("EmailAutomizationDAO::betaIncidentFileProcessor::There is some problem in inserting data into table......" + e); 						
					}
					
				}

				@Override
				public int getBatchSize() {
					logger.info("EmailAutomizationDAO::betaIncidentFileProcessor::Total Record inserted::"+ betaIncident.size()); 	
					return betaIncident.size();
				}
						
				
			  });	
		 
		logger.info("EmailAutomizationDAO::betaIncidentFileProcessor::End"); 	
	}
	
	

	@Override
	public void cmcCasesFileProcessor(List<CmcCases> cmcCases){
		logger.info("EmailAutomizationDAO::cmcCasesFileProcessor::Start"); 	
		
		  	  
		  String sql = "insert into cmc_cases ( id,submissionDate,claimTotal,claimfee,status) values (nextval('cmc_cases_id_seq'),?,?,?,?)";
				  
				  
		  jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
					
			@Override
			public void setValues(PreparedStatement ps, int i) {
				try {			
					ps.setString(1, cmcCases.get(i).getSubmissionDate());
					ps.setDouble(2, cmcCases.get(i).getClaimTotal());				
					ps.setDouble(3, cmcCases.get(i).getClaimfee());
					ps.setString(4, cmcCases.get(i).getStatus());
					
				}catch(SQLException e) {			
					logger.error("EmailAutomizationDAO::cmcCasesFileProcessor::There is some problem in inserting data into table......" + e); 						
				}
				
			}

			@Override
			public int getBatchSize() {
				logger.info("EmailAutomizationDAO::cmcCasesFileProcessor::Total Record inserted::"+ cmcCases.size()); 	
				return cmcCases.size();
			}
					
			
		  });
		  logger.info("EmailAutomizationDAO::cmcCasesFileProcessor::End"); 
	}
	
	@Override
	public void cmcDefenceFileProcessor(List<CmcDefence> cmcDefence){
		logger.info("EmailAutomizationDAO::cmcDefenceFileProcessor::Start"); 	
		
		  	  
		  String sql = "insert into cmc_defence (id,submissionDate,mediationPaid,status) values (nextval('cmc_cases_id_seq'),?,?,?)";
				  
				  
		  jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
					
			@Override
			public void setValues(PreparedStatement ps, int i) {
				try {			
					ps.setString(1, cmcDefence.get(i).getSubmissionDate());
					ps.setString(2, cmcDefence.get(i).getMediationPaid());				
					ps.setString(3, cmcDefence.get(i).getStatus());
					
				}catch(SQLException e) {			
					logger.error("EmailAutomizationDAO::cmcCasesFileProcessor::There is some problem in inserting data into table......" + e); 						
				}
				
			}

			@Override
			public int getBatchSize() {
				logger.info("EmailAutomizationDAO::cmcDefenceFileProcessor::Total Record inserted::"+ cmcDefence.size()); 	
				return cmcDefence.size();
			}
					
			
		  });
		  logger.info("EmailAutomizationDAO::cmcDefenceFileProcessor::End"); 
	}
	
	@Override
	public void cmcJudgementFileProcessor(List<CmcJudgement> cmcJudgement){
		logger.info("EmailAutomizationDAO::cmcJudgement::Start"); 	
		
		  	  
		  String sql = "insert into cmc_judgement ( id,requestedDate,payDetail,populationConfirmation,errorsEncountered) values (nextval('cmc_cases_id_seq'),?,?,?,?)";
				  
				  
		  jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
					
			@Override
			public void setValues(PreparedStatement ps, int i) {
				try {			
					ps.setString(1, cmcJudgement.get(i).getRequestedDate());
					ps.setString(2, cmcJudgement.get(i).getPayDetail());				
					ps.setString(3, cmcJudgement.get(i).getPopulationConfirmation());
					ps.setString(4, cmcJudgement.get(i).getErrorsEncountered());					
				}catch(SQLException e) {			
					logger.error("EmailAutomizationDAO::cmcJudgement::There is some problem in inserting data into table......" + e); 						
				}
				
			}

			@Override
			public int getBatchSize() {
				logger.info("EmailAutomizationDAO::cmcJudgement::Total Record inserted::"+ cmcJudgement.size()); 	
				return cmcJudgement.size();
			}
					
			
		  });
		  logger.info("EmailAutomizationDAO::cmcJudgement::End"); 
	}
	
	
	@Override
	public void betaCasesFileProcessor(List<BetaCases> betaCases) {
		 logger.info("EmailAutomizationDAO::betaCasesFileProcessor::Start"); 
		 
		 String sql = "insert into beta_cases (id,priority,state,shortDescription,description,category,assignmentGroup,numbers,service,serviceOffering,created,updated) values (nextval('beta_cases_id_seq'),?,?,?,?,?,?,?,?,?,?,?)";
		 jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps, int i) {
					try {			
						ps.setString(1, betaCases.get(i).getPriority());
						ps.setString(2, betaCases.get(i).getState());				
						ps.setString(3, betaCases.get(i).getShortDescription());
						ps.setString(4, betaCases.get(i).getDescription());	
						ps.setString(5, betaCases.get(i).getCategory());
						ps.setString(6, betaCases.get(i).getAssignmentGroup());	
						ps.setString(7, betaCases.get(i).getNumbers());
						ps.setString(8, betaCases.get(i).getService());	
						ps.setString(9, betaCases.get(i).getServiceOffering());
						ps.setString(10, betaCases.get(i).getCreated());
						ps.setString(11, betaCases.get(i).getUpdated());
						
					}catch(SQLException e) {			
						logger.error("EmailAutomizationDAO::betaCasesFileProcessor::There is some problem in inserting data into table......" + e); 						
					}
					
				}

				@Override
				public int getBatchSize() {
					logger.info("EmailAutomizationDAO::betaCasesFileProcessor::Total Record inserted::"+ betaCases.size()); 	
					return betaCases.size();
				}
						
				
			  });	
		 
		logger.info("EmailAutomizationDAO::betaCasesFileProcessor::End"); 	
	}
	
	
}
