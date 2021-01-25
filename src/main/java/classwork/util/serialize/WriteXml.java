package classwork.util.serialize;

import classwork.da.serialize.SerializeReader;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

/** Восстановление данных из сохраненного состояния в файле temp.serial.out
 *  Сохраниение в json формате в файл result_parameters.serial.json
 * */
public class WriteXml {

    public static final String SOURCE_FILE = "temp.serial.out";
    public static final String RESULT_FILE = "result_parameters.serial.xml";

    public static void main(String... args) throws Exception {

        System.out.println("Read from: " + SOURCE_FILE + "\nWrite to " + RESULT_FILE+ "\n");
        new XmlMapper().writeValue(
                new File(RESULT_FILE),
                new SerializeReader().customSerializeReader(SOURCE_FILE)
        );
    }

}
