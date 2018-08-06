package uk.gov.hmcts.reform.rmi.scheduledTask;



import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
import uk.gov.hmcts.reform.rmi.service.EmailAutomizationServiceImpl;
import uk.gov.hmcts.reform.rmi.service.FindFileInContainer;



@Component
public class CardPaymentFileProcessorTask {
	
	private static final Logger logger = LoggerFactory.getLogger(CardPaymentFileProcessorTask.class);
	
	@Autowired
	private FindFileInContainer findfileInContainer;
	
	@Autowired
	private EmailAutomizationServiceImpl emailAutomizationService;

	//Mapping Function for Payment DTO.
	private  Function<String, PaymentDTO> mapToItemPayment = (line) -> {
		
		  String[] p = line.split(",");
		  PaymentDTO items = new PaymentDTO(p[0], p[1], p[2], p[3],  p[4], p[5], p[6], p[7], p[8], p[9], Double.parseDouble(p[10]), p[11], p[12], p[13], Double.parseDouble(p[14]), p[15], p[16], p[17]);		  
		  return items;
	};

	@Scheduled(cron = "0 30 10,14 * * ?", zone="Europe/London")
	public void processCardPaymentFile() {
			
		String fileName = findfileInContainer.retunFileName("hmcts_card_payments");
		ByteArrayInputStream filedata = null;
		
		
		if (!fileName.equals("NOT_FOUND")) {
			filedata  = findfileInContainer.retunFileData(fileName.substring(fileName.lastIndexOf("/")+1));
			
			try (BufferedReader brr = new BufferedReader(new InputStreamReader(filedata, "UTF-8"))) {	
				
				List<PaymentDTO> paymentDTO = brr.lines().skip(1).map(mapToItemPayment).collect(Collectors.toList());				
				logger.info("Total Record Found in Card Payment file:: " +paymentDTO.size());
				
				emailAutomizationService.cardPaymentFileProcessor(paymentDTO);
				
			} catch (IOException e) {
				logger.info("Found error while reading data from Card Payment FIle:: " + e.getStackTrace());	
			}
			
			
		} else {			
			logger.info("No file found for Payment in container");
		}
		
		
	}
	
	//Mapping Function for Probate DTO.
	private  Function<String, ScssDTO> mapToItemSscs = (line) -> {
				
		String[] p = line.split(",");
		ScssDTO items = new ScssDTO(p[0],p[1],p[2],p[3],p[4],p[5],p[6],p[7],p[8]);		  
		return items;
	};
	
	@Scheduled(cron = "0 30 10,14 * * ?", zone="Europe/London")
	public void processScssFile() {
				
		String fileName = findfileInContainer.retunFileName("sscs");
		ByteArrayInputStream filedata = null;
			
			
		if (!fileName.equals("NOT_FOUND")) {
			filedata  = findfileInContainer.retunFileData(fileName.substring(fileName.lastIndexOf("/")+1));
				
			try (BufferedReader brr = new BufferedReader(new InputStreamReader(filedata, "UTF-8"))) {	
					
				List<ScssDTO> scssDTO = brr.lines().skip(1).map(mapToItemSscs).collect(Collectors.toList());				
				logger.info("Total Record Found in SSCS file:: " +scssDTO.size());
					
				emailAutomizationService.scssFileProcessor(scssDTO);
					
			} catch (IOException e) {
				logger.info("Found error while reading data from SSCS FIle:: " + e.getStackTrace());	
			}
				
				
		} else {			
			logger.info("No file found for SSCS in container");
		}
			
			
	}
	
	
	//Mapping Function for Divorce DTO.
	private Function<String, DivorceDTO> mapToItemDivorce = (line) -> {
		
		  String[] p = line.split(",");
		  DivorceDTO items = new DivorceDTO(p[0], p[2], Double.parseDouble(p[3]));		  
		  return items;
	};
	
	@Scheduled(cron = "0 30 10,14 * * ?", zone="Europe/London")
	public void processDivorceFile() {
			
		String fileName = findfileInContainer.retunFileName("divorce");
		ByteArrayInputStream filedata = null;
		
		
		if (!fileName.equals("NOT_FOUND")) {
			filedata  = findfileInContainer.retunFileData(fileName.substring(fileName.lastIndexOf("/")+1));
			
			try (BufferedReader brr = new BufferedReader(new InputStreamReader(filedata, "UTF-8"))) {	
				
				List<DivorceDTO> divorceDTO = brr.lines().skip(1).map(mapToItemDivorce).collect(Collectors.toList());				
				logger.info("Total Record Found in Card Payment file:: " +divorceDTO.size());
				
				emailAutomizationService.divorceFileProcessor(divorceDTO);
				
			} catch (IOException e) {
				logger.info("Found error while reading data from Card Payment FIle:: " + e.getStackTrace());	
			}
			
			
		} else {			
			logger.info("No file found for Divorce in container");
		}
		
		
	}
	
	
	//Mapping Function for Probate DTO.
	private Function<String, ProbateDTO> mapToItemProbate = (line) -> {
			
			 String[] p = line.split(",");
			 ProbateDTO items = new ProbateDTO(p[0], p[2], Double.parseDouble(p[3]));		  
			 return items;
	};
		
	@Scheduled(cron = "0 30 10,14 * * ?", zone="Europe/London")
	public void processProbateFile() {
				
		String fileName = findfileInContainer.retunFileName("probate");
		ByteArrayInputStream filedata = null;
			
			
		if (!fileName.equals("NOT_FOUND")) {
			filedata  = findfileInContainer.retunFileData(fileName.substring(fileName.lastIndexOf("/")+1));
				
			try (BufferedReader brr = new BufferedReader(new InputStreamReader(filedata, "UTF-8"))) {	
					
				List<ProbateDTO> probateDTO = brr.lines().skip(1).map(mapToItemProbate).collect(Collectors.toList());				
				logger.info("Total Record Found in Probate file:: " +probateDTO.size());
					
				emailAutomizationService.probateFileProcessor(probateDTO);
					
			} catch (IOException e) {
				logger.info("Found error while reading data from Probate FIle:: " + e.getStackTrace());	
			}
				
				
		} else {			
			logger.info("No file found for Probate in container");
		}
			
			
	}

	//Mapping Function for Payment Account DTO.
	private  Function<String, PaymentAccountDTO> mapToItemPaymentAccount = (line) -> {
			
			 String[] p = line.split(",");
			 PaymentAccountDTO items = new PaymentAccountDTO(p[0], p[1], p[2], p[3],  p[4], p[5], p[6], p[7],p[8], p[9], p[10], p[11], p[12], Double.parseDouble(p[13]), p[14], p[15], p[16], Double.parseDouble(p[17]), p[18], p[19], p[20]);	
			 return items;
	};
		
	@Scheduled(cron = "0 30 10,14 * * ?", zone="Europe/London")
	public void processPaymentAccountFile() {
				
		String fileName = findfileInContainer.retunFileName("credit_account_payments");
		ByteArrayInputStream filedata = null;
			
			
		if (!fileName.equals("NOT_FOUND")) {
			filedata  = findfileInContainer.retunFileData(fileName.substring(fileName.lastIndexOf("/")+1));
				
			try (BufferedReader brr = new BufferedReader(new InputStreamReader(filedata, "UTF-8"))) {	
					
				List<PaymentAccountDTO> paymentAccountDTO = brr.lines().skip(1).map(mapToItemPaymentAccount).collect(Collectors.toList());				
				logger.info("Total Record Found in Payment Account file:: " +paymentAccountDTO.size());
					
				emailAutomizationService.paymentAccountFileProcessor(paymentAccountDTO);
				findfileInContainer.deleteFile(fileName);
					
			} catch (IOException e) {
				logger.info("Found error while reading data from Payment Account FIle:: " + e.getStackTrace());	
			}
				
				
		} else {			
			logger.info("No file found for Payment Account in container");
		}
			
			
	}
	
	@Scheduled(cron = "0 30 10,14 * * ?", zone="Europe/London")
	public void processBetaIncident(){
		logger.info("CardPaymentFileProcessorTask:processBetaIncident:: Started");		
		String fileName = findfileInContainer.retunFileName("Public_Beta_Incidents");
		ByteArrayInputStream filedata = null;			
			
		if (!fileName.equals("NOT_FOUND")) {
			
			
			filedata  = findfileInContainer.retunFileData(fileName.substring(fileName.lastIndexOf("/")+1));			
			
			try {	
					Workbook workbook = new XSSFWorkbook(filedata);					
					Sheet sheet = workbook.getSheetAt(0);
					Iterator rowIterator = sheet.iterator();
					List<BetaIncident> betaincidentlist = new ArrayList<>();
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
					while (rowIterator.hasNext()) {
						BetaIncident betaincident = new BetaIncident();					
						Row row = (Row) rowIterator.next();
						Iterator cellIterator = row.cellIterator();
						
							if (row.getRowNum() == 0) continue;
							while (cellIterator.hasNext()) {						 
								Cell cell = (Cell) cellIterator.next();						 
								switch (cell.getColumnIndex()) {
								case 0:
									betaincident.setPriority(cell.getStringCellValue());
									break;							
								case 1:
									betaincident.setIncidentState(cell.getStringCellValue());
									break;	
								case 2:
									betaincident.setState(cell.getStringCellValue());
									break;	
								case 3:
									betaincident.setShortDescription(cell.getStringCellValue());
									break;	
								case 4:
									betaincident.setCategory(cell.getStringCellValue());
									break;	
								case 5:
									betaincident.setSubCategory(cell.getStringCellValue());
									break;	
								case 6:
									betaincident.setDescription(cell.getStringCellValue());
									break;	
								case 7:
									betaincident.setAssignmentGroup(cell.getStringCellValue());
									break;	
								case 8:
									betaincident.setThirdPartysupportReference(cell.getStringCellValue());
									break;	
								case 9:
									betaincident.setMadeSla(cell.getBooleanCellValue());
									break;	
								case 10:
									betaincident.setServiceOffering(cell.getStringCellValue());
									break;	
								case 11:
									betaincident.setServicePortfolio(cell.getStringCellValue());
									break;	
								case 12:
									betaincident.setService(cell.getStringCellValue());
									break;	
								case 13:
									betaincident.setContactType(cell.getStringCellValue());
									break;	
								case 14:								
									if (cell.getDateCellValue()==null) {
										betaincident.setCreatedDateTime("");
									}
									else {
											betaincident.setCreatedDateTime(dateFormat.format(cell.getDateCellValue()).toString());
										}
									break;	
								case 15:
									if (cell.getDateCellValue()==null) {
										betaincident.setUpdatedDateTime("");
									}else {
										betaincident.setUpdatedDateTime(dateFormat.format(cell.getDateCellValue()).toString());
									}								
									break;	
								case 16:								
									if (cell.getCellType()== 0)
										betaincident.setResolveTime(Double.toString(cell.getNumericCellValue()));									
									else
										betaincident.setResolveTime(cell.getStringCellValue());								
									break;	
								case 17:
									if (cell.getDateCellValue()==null) {
										betaincident.setResolved("");
									}else {
										betaincident.setResolved(dateFormat.format(cell.getDateCellValue()).toString());
									}
									break;	
								 }
								}	
							betaincidentlist.add(betaincident);
					 }
						emailAutomizationService.betaIncidentFileProcessor(betaincidentlist);
						logger.info("CardPaymentFileProcessorTask:processBetaIncident:: End");		
					} catch (IOException ioe) {
							logger.error("Error while reading the Excel file: ", ioe);			
					}		
			} else {			
				logger.info("No file found for Beta Incident in container");
			}			
			
	}

	@Scheduled(cron = "0 30 10,14 * * ?", zone="Europe/London")
	public void processCmcfile(){
		logger.info("CardPaymentFileProcessorTask:processCmcfile:: Started");		
		String fileName = findfileInContainer.retunFileName("CMC.combine");
		ByteArrayInputStream filedata = null;			
			
		if (!fileName.equals("NOT_FOUND")) {			
			
			filedata  = findfileInContainer.retunFileData(fileName.substring(fileName.lastIndexOf("/")+1));			
			
			try {	
			    Workbook workbook = new XSSFWorkbook(filedata);
				Sheet sheet = workbook.getSheetAt(0);
				Iterator rowIterator = sheet.iterator();
				List<CmcCases> cmcCaseslist = new ArrayList<>();				
				
				 while (rowIterator.hasNext()) {
					 CmcCases cmcCases = new CmcCases();					
					 Row row = (Row) rowIterator.next();
					 Iterator cellIterator = row.cellIterator();
					 if (row.getRowNum() == 0) continue;
					 while (cellIterator.hasNext()) {						 
						 Cell cell = (Cell) cellIterator.next();						 
						 switch (cell.getColumnIndex()) {
							case 0:								
								cmcCases.setSubmissionDate(String.valueOf(cell.getNumericCellValue()));
								break;							
							case 1:								
								cmcCases.setClaimTotal(cell.getNumericCellValue());
								break;	
							case 2:								
								cmcCases.setClaimfee(cell.getNumericCellValue());
								break;	
							case 3:								
								cmcCases.setStatus(cell.getStringCellValue());
								break;	
							}
					 }
					 cmcCaseslist.add(cmcCases);					
				 }				
				
				emailAutomizationService.cmcCasesFileProcessor(cmcCaseslist);				
				logger.info("Success Fully processed First sheet of CMC file:");	
				cmcCaseslist.clear();
				
					sheet = workbook.getSheetAt(1);
					rowIterator = sheet.iterator();
					List<CmcDefence> cmcDefencelist = new ArrayList<>();				
						
					while (rowIterator.hasNext()) {
						CmcDefence cmcDefence = new CmcDefence();					
						Row row = (Row) rowIterator.next();
						Iterator cellIterator = row.cellIterator();
						if (row.getRowNum() == 0) continue;
						 while (cellIterator.hasNext()) {						 
							 Cell cell = (Cell) cellIterator.next();						 
							 switch (cell.getColumnIndex()) {
								case 0:									
									cmcDefence.setSubmissionDate(String.valueOf(cell.getStringCellValue()));
									break;							
								case 1:									
									cmcDefence.setMediationPaid(cell.getStringCellValue());
									break;	
								case 2:									
									cmcDefence.setStatus(cell.getStringCellValue());
									break;
								}
						 }
						 cmcDefencelist.add(cmcDefence);
					}
					
				
				emailAutomizationService.cmcDefenceFileProcessor(cmcDefencelist);				
				logger.info("Success Fully processed Second sheet of CMC file:");	
				cmcCaseslist.clear();	
					
					sheet = workbook.getSheetAt(2);
					rowIterator = sheet.iterator();
					List<CmcJudgement> cmcJudgementlist = new ArrayList<>();			
						
					 while (rowIterator.hasNext()) {
						 CmcJudgement cmcJudgement = new CmcJudgement();					
						 Row row = (Row) rowIterator.next();
						 Iterator cellIterator = row.cellIterator();
						 if (row.getRowNum() == 0) continue;
						 while (cellIterator.hasNext()) {						 
							 Cell cell = (Cell) cellIterator.next();						 
							 switch (cell.getColumnIndex()) {
								case 0:									
									cmcJudgement.setRequestedDate(String.valueOf(cell.getNumericCellValue()));
									break;							
								case 1:									
									cmcJudgement.setPayDetail(cell.getStringCellValue());
									break;	
								case 2:									
									cmcJudgement.setPopulationConfirmation(cell.getStringCellValue());
									break;
								case 3:									
									cmcJudgement.setErrorsEncountered(cell.getStringCellValue());
									break;
								}
						 }						 
						 cmcJudgementlist.add(cmcJudgement);					
				}
				
				emailAutomizationService.cmcJudgementFileProcessor(cmcJudgementlist);				
				logger.info("Success Fully processed Third sheet of CMC file:");	
				
				} catch (IOException ioe) {
							logger.error("Error while reading the Excel file: ", ioe);			
				}		
			} else {			
				logger.info("No file found for CMC in container");
			}			
			
	}
	
	
	@Scheduled(cron = "0 30 10,14 * * ?", zone="Europe/London")
	public void processBetaCases(){
		logger.info("CardPaymentFileProcessorTask:processBetaCases:: Started");		
		String fileName = findfileInContainer.retunFileName("Beta_Cases");
		ByteArrayInputStream filedata = null;			
			
		if (!fileName.equals("NOT_FOUND")) {
			
			
			filedata  = findfileInContainer.retunFileData(fileName.substring(fileName.lastIndexOf("/")+1));			
			
			try {	
					Workbook workbook = new XSSFWorkbook(filedata);					
					Sheet sheet = workbook.getSheetAt(0);
					Iterator rowIterator = sheet.iterator();
					List<BetaCases> betaCaseslist = new ArrayList<>();
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
					while (rowIterator.hasNext()) {
						BetaCases betaCases = new BetaCases();					
						Row row = (Row) rowIterator.next();
						Iterator cellIterator = row.cellIterator();
						
							if (row.getRowNum() == 0) continue;
							while (cellIterator.hasNext()) {						 
								Cell cell = (Cell) cellIterator.next();						 
								switch (cell.getColumnIndex()) {
								case 0:
									betaCases.setPriority(cell.getStringCellValue());
									break;							
								case 1:
									betaCases.setState(cell.getStringCellValue());
									break;	
								case 2:
									betaCases.setShortDescription(cell.getStringCellValue());
									break;	
								case 3:
									betaCases.setDescription(cell.getStringCellValue());
									break;
								case 4:	
									betaCases.setCategory(cell.getStringCellValue());
									break;	
								case 5:
									betaCases.setAssignmentGroup(cell.getStringCellValue());
									break;	
								case 6:
									betaCases.setNumbers(cell.getStringCellValue());
									break;	
								case 7:
									betaCases.setService(cell.getStringCellValue());
									break;	
								case 8:
									betaCases.setServiceOffering(cell.getStringCellValue());
									break;	
								case 9:								
									if (cell.getDateCellValue()==null) {
										betaCases.setCreated("");
									}
									else {
										betaCases.setCreated(dateFormat.format(cell.getDateCellValue()).toString());
										}
									break;	
								case 10:
									if (cell.getDateCellValue()==null) {
										betaCases.setUpdated("");
									}else {
										betaCases.setUpdated(dateFormat.format(cell.getDateCellValue()).toString());
									}								
									break;									
								 }
								}	
							betaCaseslist.add(betaCases);
					 }
						emailAutomizationService.betaCasesFileProcessor(betaCaseslist);
						logger.info("CardPaymentFileProcessorTask:processBetaCases:: End");		
					} catch (IOException ioe) {
							logger.error("Error while reading the Excel file: ", ioe);			
					}		
			} else {			
				logger.info("No file found for Beta Incident in container");
			}			
			
	}
	
	
}
