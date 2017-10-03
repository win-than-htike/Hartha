package xyz.aungpyaephyo.shared.utils;

import android.content.Context;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aung on 12/12/15.
 */
public class JsonUtils {

    private static final String PATH_DUMMY_DATA = "sample-data";
    private static final String OFFLINE_JSON_FILE_V1 = "padc-renty-export.json";
    private static final String OFFLINE_JSON_FILE_V2 = "renty_pp_ps_pseudo_data_v1.json";

    /**
     * Read text from assets folder.
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    private static byte[] readJsonFile(Context context, String fileName) throws IOException {
        InputStream inStream = context.getAssets().open(fileName);
        int size = inStream.available();
        byte[] buffer = new byte[size];
        inStream.read(buffer);
        inStream.close();
        return buffer;
    }

    /**
     * @param fileName - name of Json File.
     * @return JSONObject from loaded file.
     * @throws IOException
     * @throws JSONException
     */
    private static String loadOfflineJson(Context context, String fileName) throws IOException, JSONException {
        byte[] buffer = readJsonFile(context, PATH_DUMMY_DATA + "/" + fileName);
        return new String(buffer, "UTF-8").toString();
    }

}
