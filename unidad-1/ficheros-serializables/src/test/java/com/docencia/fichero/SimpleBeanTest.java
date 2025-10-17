package com.docencia.fichero;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.docencia.fichero.serializacion.SimpleBean;
class SimpleBeanTest {

    @Test
    void simpleBeanDeserializarTest(){
        XmlMapper xmlMapper = new XmlMapper();
        String xml;
        try {
            SimpleBean value = xmlMapper.readValue("<SimpleBean><x>1</x><y>2</y></SimpleBean>", SimpleBean.class);
            assertTrue(value.getX() == 1 && value.getY() == 2);
            
            xml = xmlMapper.writeValueAsString(new SimpleBean());
            assertNotNull(xml);
            assertTrue(xml.contains("<x>1</x>"));
        } catch (JsonProcessingException e) {
            Assertions.fail("error no controlado",e);
        }
    }
}
