package homework.v3;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import homework.v3.entity.JsonParameters;
import homework.v3.entity.JsonParametersExt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Задание
 * 1) Составить файл с JSON-объектом, который "разложен" в пакете homework.v3.classwork.entity.
 * Определить какой элемент является корневым
 * Дать имя файлу homework.parameters.json
 * Сделать файл с минимум пятью элементами
 * 2) Заполнить его значениями (как пример "parameters.v1.json")
 * 3) Считать получившийся homework.parameters.json в память
 * 4) Сериализовать его с помощью встроенного механиза сериализации в файл с именем homework.parameters.ser
 * 5) Сериализовать его с использованием интерфейса Externalizable в файл с именем homework.parameters.exter
 * 6) Считать данные из файла homework.parameters.ser в память и сохранить в формате JSON в файл с именем homework.result.ser.parameters.json
 * 7) Считать данные из файла homework.parameters.exter в память и сохранить в формате JSON в файл с именем homework.result.exter.parameters.json
 * 8) Убедиться, что файлы homework.result.ser.parameters.json и  homework.result.exter.parameters.json
 * совпадают с homework.parameters.json
 * 9) Составленную в п.1 сущность представить в виде xsd-схемы и
 * выполнить генерацию классов аналогично классам из пакета classwork.entity.jaxb
 * * можно сделать и с json-схемой, пренципиально механизм не поменяется.
 */

public class HomeWork {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //3 - Считывание
        final String filePath = "C:\\Users\\пк\\IdeaProjects\\wardenka-serialize-study-util-3e114e58d874\\src\\main\\resources\\homework.parameters.json";
        ObjectMapper mapper = new ObjectMapper();
        List<JsonParameters> parameters = mapper.readValue(new File(filePath), new TypeReference<List<JsonParameters>>() {
        });
        List<JsonParametersExt> parametersExt = mapper.readValue(new File(filePath), new TypeReference<List<JsonParametersExt>>() {
        });
        //4 - обычная сериализация

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("homework.parameters.ser"));

        for (JsonParameters parameter : parameters) {
            oos.writeObject(parameter);

        }
        oos.flush();
        oos.close();

        //5 - Externalizable
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("homework.parameters.exter"));
        for (JsonParametersExt parameter : parametersExt) {
            out.writeObject(parameter);

        }

        out.close();

        //6 homework.result.ser.parameters.json
        FileInputStream fis = new FileInputStream("homework.parameters.ser");
        ObjectInputStream oin = new ObjectInputStream(fis);
        //Надо сделать цикл
        JsonParameters parameter1 = (JsonParameters) oin.readObject();
        JsonParameters parameter2 = (JsonParameters) oin.readObject();
        JsonParameters parameter3 = (JsonParameters) oin.readObject();
        JsonParameters parameter4 = (JsonParameters) oin.readObject();
        JsonParameters parameter5 = (JsonParameters) oin.readObject();
        List<JsonParameters> tempParameters = new ArrayList<>();
        tempParameters.add(parameter1);
        tempParameters.add(parameter2);
        tempParameters.add(parameter3);
        tempParameters.add(parameter4);
        tempParameters.add(parameter5);

        try {
            mapper.writeValue(new File("homework.result.ser.parameters.json"), tempParameters);
        } catch (JsonGenerationException exc) {
            exc.printStackTrace();
        } catch (JsonMappingException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        //7 homework.result.ser.parameters.json
        FileInputStream fisExt = new FileInputStream("homework.parameters.exter");
        ObjectInputStream oinExt = new ObjectInputStream(fisExt);
        //Надо сделать цикл
        JsonParametersExt parameter1_Ext = (JsonParametersExt) oinExt.readObject();
        JsonParametersExt parameter2_Ext = (JsonParametersExt) oinExt.readObject();
        JsonParametersExt parameter3_Ext = (JsonParametersExt) oinExt.readObject();
        JsonParametersExt parameter4_Ext = (JsonParametersExt) oinExt.readObject();
        JsonParametersExt parameter5_Ext = (JsonParametersExt) oinExt.readObject();
        List<JsonParametersExt> tempParameters_Ext = new ArrayList<>();
        tempParameters_Ext.add(parameter1_Ext);
        tempParameters_Ext.add(parameter2_Ext);
        tempParameters_Ext.add(parameter3_Ext);
        tempParameters_Ext.add(parameter4_Ext);
        tempParameters_Ext.add(parameter5_Ext);

        try {
            mapper.writeValue(new File("homework.result.exter.parameters.json"), tempParameters_Ext);
        } catch (JsonGenerationException exc) {
            exc.printStackTrace();
        } catch (JsonMappingException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }

    }
}

