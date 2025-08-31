package org.airtribe;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;

public class DropboxApiExample {
    private static final String ACCESS_TOKEN = "sl.u.AF-52Mxk4qRLcDYyz4kkOzj45JPdsWBU7JDkKSXJVm4h7_yRwFS3Hi1XF3CLV7wp8Si9uJoZxdESYSYVRLODrK0PG_Vnh-eQxUh0SwilaMB4ff5RM5LG-NIWgfYuHBrHms_qfZJFM4TxliAHK2UO-UsiqxD790naCMC_nc8i0UzO8rMQC25PO3isU0bArfj2THOGQp--_Q1oYxQtt9k_99dWnuzsWLeNXV_JBHq7pZb4eQPvkAnB5SmKJxKwmLjMLrctEiOCSUFR47r0bhrNgb2NCFOOTc2b09nNVkDdZCfNVnDfZYf-Om9CuBrlAmu3KFT6VrHwQqn01EwGNEjDoplkR4eAjq9Gb-ueuoQb4nmLWYwIeRNU75mWNMHTs9j4q3nHd8paZCTiYSueWBKA1ACCUGFWKdH-CO46CEp2-exrjGdwWz0ljyv7N6w_PhrYKRQq6ivKjvpfBtEdDGWgWWDpy3q96_EdA_b7ZPXZC6O7yk16oYrI-A5u4sopywrWU4n5ypEyntoOD5d7tRa41qrcwvI7DPiCfnzVzik4zofAPDCXZ3yGZxxeR3JqUMu9HxXSkKhmPOmfXPOSc1hEN1WiYMuYI00Gv8NKMnCUPi7ErbN7g5qIeyU4j3_hcCp3wGkTanPFNFS82qmXra5bIkxrxGEitEaw54at9cajjEHwzhj1CqsBCjT1sFVLd6HXdPcOZAW_Z5C63IX4BalEPuDPWV_grOT9KoGTIUJo0WPFQP2_vPYVUPRHJI4bkTjRPq6jDDxs253ZLSGSjsOCTh0K019j_R3RDnoay3Z2iymW5jEVmIM1cS6HMnLBFrWUF75HRy7bui6UHQWHz6VZeOc42RIDlfc3pNcWu3YPY7RfbvTtr5S2RUODXmQXNVJXZf75kApqkzPjCMymAJSQLqO27vfDgbLq5cIEpTBJkhQN9hCLaryE9bM52Hefq7HI_Gq_C-DPb5oZ9n1HswnA1g1wfGIygZxCi3WpwdetV8K7ye5n37Qg7Y8H3K2VaubHStwA3tCRfCcUI4RtHoq05CSRNH_YTzqlQR5GTZPYX8cCrZ2Ekch2zG-4p2EnJdb53uyNCqOcCMu23xC9zJ0scEMQuKqvCX0ef0reLidhIEQkHi9c3p9S2es8Im6txi4vot__Zgeyu5VYNk90MwCj6Hd7iWPIDXzZvygKoSxQ3W-4bZuzBWQDbNcKXKeDs9ONSa5WeOhxO9h7YYib_ZXa4xhGI1F83TIMxGBQSmI7wdXMhyIUK0P_ZP8DaT9L7VvJJEY90zY0ILxoDM6O7aEsqKCIQ1fcJPWgHgCiPWeGcSOHssLQ-Jj2jXhPLb8m-HZq8qFF8LErwbMBWasZij0wa3mPdadtpxkIYBBl4mzUYocgiQ7OKQH2xlr_rNj1H0J4R7TbG4Pe68r1Bguv4x7RO4ARJSVeSAQT4gLLt7fIAqjosg";
    private static final String API_URL= "https://api.dropbox.com/2/team/get_info";

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(API_URL)
                .post(RequestBody.create("", MediaType.parse("application/json")))
                .addHeader("Authorization","Bearer" + ACCESS_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        try(Response response = client.newCall(request).execute()) {
            if(!response.isSuccessful()){
                System.err.println("Error: "+ response.code() + " - "+ response.message());
                if(response.body()!=null){
                    System.err.println("Details: "+ response.body().string());
                }
                return;
            }
            String responseBody = response.body() != null ? response.body().string() : "{}";

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(responseBody);
            System.out.println("Dropbox Team Info:\n" +
                    mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
























