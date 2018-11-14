package fr.utbm.lo54.coursesession.utilDate;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


		/**																							**
					 * 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*																	*
					 * CETTE CLASSE PERMET DE CONVERTIR LOCALDATE, QUI EST DE TYPE TINYBLOB	*
					 * DANS MYSQL, AU TYPE DATE												*
					 * 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*								
		**																							**/



@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
	
    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
    	return (locDate == null ? null : Date.valueOf(locDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
    	return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
}


