package ru.oschepkov.Validators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonValidator implements IValidator {

    static final String PATH_TO_SCHEMA = "src\\main\\resourses\\jsonSchema.json";



    @Override
    public boolean isValid(String path) throws FileNotFoundException{

        File schemaFile = new File(PATH_TO_SCHEMA);

        JSONTokener schemaData = new JSONTokener(new FileInputStream(schemaFile));
        JSONObject jsonSchema = new JSONObject(schemaData);

        File jsonData = new File(path);
        JSONTokener jsonDataFile = new JSONTokener(new FileInputStream(jsonData));
        JSONObject jsonObject = new JSONObject(jsonDataFile);

        Schema schemaValidator = SchemaLoader.load(jsonSchema);

        try {
            schemaValidator.validate(jsonObject);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}


    

