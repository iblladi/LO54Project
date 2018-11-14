package fr.utbm.lo54.coursesession.utilDate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

		/**																							**
				 * 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*																	*
				 * CETTE CLASSE PERMET DE CONVERTIR LOCALDATETIME, QUI EST DE TYPE TINYBLOB	*
				 * DANS MYSQL, AU TYPE TIMESTAMP											*
				 * 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*								
		**																							**/

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
	
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
    	return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
    	return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
    }
}