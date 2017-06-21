package ba.isss.restservices.mappers;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@Component
public class DmkObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = -5331213544929498810L;

	public DmkObjectMapper() {
		registerModule(new Hibernate5Module());
    }

}