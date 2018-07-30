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

import uk.gov.hmcts.reform.rmi.model.PaymentDTO;


@Transactional
@Repository
public class EmailAutomizationDAO implements EmailAutomizationDAOImpl {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(EmailAutomizationDAO.class);
		
	@Override
	public void cardPaymentFileProcessor(List<PaymentDTO>  paymentDTO){
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
	
}
