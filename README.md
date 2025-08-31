# Dropbox API Example in Java

This project demonstrates how to implement authentication and fetch user account details using the Dropbox API in Java with OkHttp and Jackson.

## 📌 Features

- Uses OkHttpClient for making HTTP requests
- Authenticates with Dropbox via Bearer Token
- Fetches current account information from Dropbox
- Pretty prints JSON response with Jackson

## 🚀 How to Run

Clone the repository:

```
git clone https://github.com/<your-username>/<your-repo>.git
cd <your-repo>
```

Replace the placeholder with your Dropbox access token:

```
private static final String ACCESS_TOKEN = "YOUR_ACCESS_TOKEN";
```

Compile & run the program in IntelliJ IDEA (or with Gradle/Maven).

Example with `javac`:

```
javac -cp ".;libs/*" DropboxApiExample.java
java -cp ".;libs/*" DropboxApiExample
```

## ✅ Example Output

When run successfully, the program prints your Dropbox account details in JSON format:
