package utils;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonDataReader {

	public static Object[][] getLoginData(String filePath, String arrayName) {

		Object[][] data = null;

		try {

			String content = new String(Files.readAllBytes(Paths.get("src\\test\\java\\resources\\loginData.json")));

			JSONObject jsonObject = new JSONObject(content);

			JSONArray jsonArray = jsonObject.getJSONArray(arrayName);

			data = new Object[jsonArray.length()][3];

			for (int i = 0; i < jsonArray.length(); i++) {

				JSONObject obj = jsonArray.getJSONObject(i);

				data[i][0] = obj.getString("userId");
				data[i][1] = obj.getString("password");
				data[i][2] = obj.getString("expectedResult");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

}
