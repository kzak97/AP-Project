/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 


/**
 *
 * @author KHAWAJA ZEESHAUR
 */
public class Test {

    
public static void addPatientPOSTRequest() throws IOException {
    
    String id = "4";
    String name = "xyz";
    String cnic = "12345";
    String contact = "0000";
    String username = "xyz";
    String password = "xyz";
    
    
    final String POST_PARAMS = "{\n" + "\"id\": " +  id + ",\r\n" +
        "    \"name\": "+ name +",\r\n" +
        "    \"cnic\": "+ cnic +",\r\n" +
        "    \"contact\": "+ contact +",\r\n" +
        "    \"username\": "+ username +",\r\n" +
        "    \"password\":"+ password +"" + "\n}";
    
    
    JSONObject jsonObj = new JSONObject();
    
    JSONArray ja = new JSONArray();
    
    jsonObj.put("password", password);
    jsonObj.put("username", username);
    jsonObj.put("id", id);
    jsonObj.put("contact", contact);
    jsonObj.put("cnic", cnic);
    jsonObj.put("name", name);
    String message = jsonObj.toString();
    System.out.println(message);
    
   
    URL obj = new URL("http://localhost:3000/patients");
    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
    postConnection.setRequestMethod("POST");
    postConnection.setRequestProperty("Content-Type", "application/json");
    postConnection.setDoOutput(true);
    
    OutputStream os = postConnection.getOutputStream();
    os.write(message.getBytes());
    os.flush();
    os.close();
    
    int responseCode = postConnection.getResponseCode();
    System.out.println("POST Response Code :  " + responseCode);
    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
        BufferedReader in = new BufferedReader(new InputStreamReader(
            postConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
        } in .close();
        // print result
        System.out.println(response.toString());
    } else {
        System.out.println("POST NOT WORKED");
    }
}
    
public static void deletePatientDELETERequest() throws IOException {
    
    
    URL obj = new URL("http://localhost:3000/patients/1");
    HttpURLConnection deleteConnection = (HttpURLConnection) obj.openConnection();
    deleteConnection.setRequestMethod("DELETE");
    deleteConnection.setRequestProperty("Content-Type", "application/json");
    deleteConnection.setRequestProperty("X-HTTP-Method-Override", "DELETE");
    deleteConnection.setDoOutput(false);
    
    int responseCode = deleteConnection.getResponseCode();
    System.out.println("DELETE Response Code :  " + responseCode);
    System.out.println("DELETE Response Message : " + deleteConnection.getResponseMessage());
}
    
public static void buyMedicinePOSTRequest() throws IOException {
    
    String id = "4";
    String name = "medicine4";
    String quantity = "40";
    
    JSONObject jsonObj = new JSONObject();
    
    jsonObj.put("id", id);
    jsonObj.put("quantity", quantity);
    jsonObj.put("name", name);
    String message = jsonObj.toString();
    System.out.println(message);
    
   
    URL obj = new URL("http://localhost:3000/medicines");
    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
    postConnection.setRequestMethod("POST");
    postConnection.setRequestProperty("Content-Type", "application/json");
    postConnection.setDoOutput(true);
    
    OutputStream os = postConnection.getOutputStream();
    os.write(message.getBytes());
    os.flush();
    os.close();
    
    int responseCode = postConnection.getResponseCode();
    System.out.println("POST Response Code :  " + responseCode);
    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
        BufferedReader in = new BufferedReader(new InputStreamReader(
            postConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
        } in .close();
        // print result
        System.out.println(response.toString());
    } else {
        System.out.println("POST NOT WORKED");
    }
}

public static void showAllMedicinesGETRequest() throws IOException {
    URL urlForGetRequest = new URL("http://localhost:3000/medicines");
    String readLine = null;
    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
    conection.setRequestMethod("GET");
    //conection.setRequestProperty("userId", "5"); // set userId its a sample here
    int responseCode = conection.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(conection.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {
            response.append(readLine);
        } in .close();
        // print result
        System.out.println("JSON String Result " + response.toString());
        //GetAndPost.POSTRequest(response.toString());
    } else {
        System.out.println("GET NOT WORKED");
    }
}
    
public static void sellMedicinePUTRequest() throws IOException {
    
    String id = "4";
    String name = "medicine5";
    String quantity = "50";
    
    JSONObject jsonObj = new JSONObject();
    jsonObj.put("quantity", quantity);
    jsonObj.put("name", name);
    String message = jsonObj.toString();
    System.out.println(message);
    
    URL obj = new URL("http://localhost:3000/medicines/3");
    HttpURLConnection putConnection = (HttpURLConnection) obj.openConnection();
    putConnection.setRequestMethod("PUT");
    putConnection.setRequestProperty("Content-Type", "application/json");
    putConnection.setDoOutput(true);
    
    OutputStream os = putConnection.getOutputStream();
    os.write(message.getBytes());
    os.flush();
    os.close();
    
    int responseCode = putConnection.getResponseCode();
    System.out.println("PUT Response Code :  " + responseCode);
    System.out.println("PUT Response Message : " + putConnection.getResponseMessage());
}

public static void deleteMedicineDELETERequest() throws IOException {
    
    
    URL obj = new URL("http://localhost:3000/medicines/1");
    HttpURLConnection deleteConnection = (HttpURLConnection) obj.openConnection();
    deleteConnection.setRequestMethod("DELETE");
    deleteConnection.setRequestProperty("Content-Type", "application/json");
    deleteConnection.setRequestProperty("X-HTTP-Method-Override", "DELETE");
    deleteConnection.setDoOutput(false);
    
    int responseCode = deleteConnection.getResponseCode();
    System.out.println("DELETE Response Code :  " + responseCode);
    System.out.println("DELETE Response Message : " + deleteConnection.getResponseMessage());
}

public static void showAppointmentsGETRequest() throws IOException {
    URL urlForGetRequest = new URL("http://localhost:3000/appointments");
    String readLine = null;
    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
    conection.setRequestMethod("GET");
    //conection.setRequestProperty("userId", "5"); // set userId its a sample here
    int responseCode = conection.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(conection.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {
            response.append(readLine);
        } in .close();
        // print result
        System.out.println("JSON String Result " + response.toString());
        //GetAndPost.POSTRequest(response.toString());
    } else {
        System.out.println("GET NOT WORKED");
    }
}

public static void makeAppointmentPOSTRequest() throws IOException {
    
    String id = "7";
    String patient = "Khawaja";
    String doctor = "doctor3";
    String start = "20";
    String finish = "21";
    String status = "active";
    
    JSONObject jsonObj = new JSONObject();
    
    jsonObj.put("id", id);
    jsonObj.put("patient", patient);
    jsonObj.put("doctor", doctor);
    jsonObj.put("start_time", start);
    jsonObj.put("finish_time", finish);
    jsonObj.put("status", status);
    String message = jsonObj.toString();
    System.out.println(message);
    
   
    URL obj = new URL("http://localhost:3000/appointments");
    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
    postConnection.setRequestMethod("POST");
    postConnection.setRequestProperty("Content-Type", "application/json");
    postConnection.setDoOutput(true);
    
    OutputStream os = postConnection.getOutputStream();
    os.write(message.getBytes());
    os.flush();
    os.close();
    
    int responseCode = postConnection.getResponseCode();
    System.out.println("POST Response Code :  " + responseCode);
    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
        BufferedReader in = new BufferedReader(new InputStreamReader(
            postConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
        } in .close();
        // print result
        System.out.println(response.toString());
    } else {
        System.out.println("POST NOT WORKED");
    }
}
    
public static void cancelAppointmentDELETERequest() throws IOException {
    
    
    URL obj = new URL("http://localhost:3000/appointments/1");
    HttpURLConnection deleteConnection = (HttpURLConnection) obj.openConnection();
    deleteConnection.setRequestMethod("DELETE");
    deleteConnection.setRequestProperty("Content-Type", "application/json");
    deleteConnection.setRequestProperty("X-HTTP-Method-Override", "DELETE");
    deleteConnection.setDoOutput(false);
    
    int responseCode = deleteConnection.getResponseCode();
    System.out.println("DELETE Response Code :  " + responseCode);
    System.out.println("DELETE Response Message : " + deleteConnection.getResponseMessage());
}
  
public static void addRoomPOSTRequest() throws IOException {
    
    String id = "4";
    String number = "room4";
    String status = "available";
    
    JSONObject jsonObj = new JSONObject();
    
    jsonObj.put("id", id);
    jsonObj.put("number", number);
    jsonObj.put("status", status);
    String message = jsonObj.toString();
    System.out.println(message);
    
   
    URL obj = new URL("http://localhost:3000/room");
    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
    postConnection.setRequestMethod("POST");
    postConnection.setRequestProperty("Content-Type", "application/json");
    postConnection.setDoOutput(true);
    
    OutputStream os = postConnection.getOutputStream();
    os.write(message.getBytes());
    os.flush();
    os.close();
    
    int responseCode = postConnection.getResponseCode();
    System.out.println("POST Response Code :  " + responseCode);
    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
        BufferedReader in = new BufferedReader(new InputStreamReader(
            postConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
        } in .close();
        // print result
        System.out.println(response.toString());
    } else {
        System.out.println("POST NOT WORKED");
    }
}
    
public static void finishRoomDELETERequest() throws IOException {
    
    
    URL obj = new URL("http://localhost:3000/rooms/1");
    HttpURLConnection deleteConnection = (HttpURLConnection) obj.openConnection();
    deleteConnection.setRequestMethod("DELETE");
    deleteConnection.setRequestProperty("Content-Type", "application/json");
    deleteConnection.setRequestProperty("X-HTTP-Method-Override", "DELETE");
    deleteConnection.setDoOutput(false);
    
    int responseCode = deleteConnection.getResponseCode();
    System.out.println("DELETE Response Code :  " + responseCode);
    System.out.println("DELETE Response Message : " + deleteConnection.getResponseMessage());
}

public static void addDoctorPOSTRequest() throws IOException {
    
    String id = "4";
    String name = "doctor4";
    String qualification = "MBBS";
    String contact = "0000";
    String status = "active";
    
    JSONObject jsonObj = new JSONObject();
    
    jsonObj.put("id", id);
    jsonObj.put("name", name);
    jsonObj.put("qualification", qualification);
    jsonObj.put("contact", contact);
    jsonObj.put("status", status);
    String message = jsonObj.toString();
    System.out.println(message);
    
   
    URL obj = new URL("http://localhost:3000/doctors");
    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
    postConnection.setRequestMethod("POST");
    postConnection.setRequestProperty("Content-Type", "application/json");
    postConnection.setDoOutput(true);
    
    OutputStream os = postConnection.getOutputStream();
    os.write(message.getBytes());
    os.flush();
    os.close();
    
    int responseCode = postConnection.getResponseCode();
    System.out.println("POST Response Code :  " + responseCode);
    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
        BufferedReader in = new BufferedReader(new InputStreamReader(
            postConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
        } in .close();
        // print result
        System.out.println(response.toString());
    } else {
        System.out.println("POST NOT WORKED");
    }
}
    
public static void updateDoctorStatusPUTRequest() throws IOException {
    
    String id = "4";
    String name = "doctor4";
    String qualification = "MBBS";
    String contact = "0000";
    String status = "unavailable";
    
    JSONObject jsonObj = new JSONObject();
    
    jsonObj.put("id", id);
    jsonObj.put("name", name);
    jsonObj.put("qualification", qualification);
    jsonObj.put("contact", contact);
    jsonObj.put("status", status);
    String message = jsonObj.toString();
    System.out.println(message);
    
    URL obj = new URL("http://localhost:3000/doctors/1");
    HttpURLConnection putConnection = (HttpURLConnection) obj.openConnection();
    putConnection.setRequestMethod("PUT");
    putConnection.setRequestProperty("Content-Type", "application/json");
    putConnection.setDoOutput(true);
    
    OutputStream os = putConnection.getOutputStream();
    os.write(message.getBytes());
    os.flush();
    os.close();
    
    int responseCode = putConnection.getResponseCode();
    System.out.println("PUT Response Code :  " + responseCode);
    System.out.println("PUT Response Message : " + putConnection.getResponseMessage());
}

public static void removeDoctorDELETERequest() throws IOException {
    
    
    URL obj = new URL("http://localhost:3000/doctors/1");
    HttpURLConnection deleteConnection = (HttpURLConnection) obj.openConnection();
    deleteConnection.setRequestMethod("DELETE");
    deleteConnection.setRequestProperty("Content-Type", "application/json");
    deleteConnection.setRequestProperty("X-HTTP-Method-Override", "DELETE");
    deleteConnection.setDoOutput(false);
    
    int responseCode = deleteConnection.getResponseCode();
    System.out.println("DELETE Response Code :  " + responseCode);
    System.out.println("DELETE Response Message : " + deleteConnection.getResponseMessage());
}  

public static void patientSpecificAppointmentGETRequest() throws IOException {
    URL urlForGetRequest = new URL("http://localhost:3000/appointments?patient=Ahmed");
    String readLine = null;
    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
    conection.setRequestMethod("GET");
    //conection.setRequestProperty("userId", "5"); // set userId its a sample here
    int responseCode = conection.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(conection.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {
            response.append(readLine);
        } in .close();
        // print result
        System.out.println("JSON String Result " + response.toString());
        //GetAndPost.POSTRequest(response.toString());
    } else {
        System.out.println("GET NOT WORKED");
    }
}

public static void availableDoctorsGETRequest() throws IOException {
    URL urlForGetRequest = new URL("http://localhost:3000/doctors?status=available");
    String readLine = null;
    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
    conection.setRequestMethod("GET");
    //conection.setRequestProperty("userId", "5"); // set userId its a sample here
    int responseCode = conection.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(conection.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {
            response.append(readLine);
        } in .close();
        // print result
        System.out.println("JSON String Result " + response.toString());
        //GetAndPost.POSTRequest(response.toString());
    } else {
        System.out.println("GET NOT WORKED");
    }
}

public static void doctorsFreeslotsGETRequest() throws IOException {
    URL urlForGetRequest = new URL("http://localhost:3000/doctor_free_slots?doctor=doctor1&status=available");
    String readLine = null;
    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
    conection.setRequestMethod("GET");
    //conection.setRequestProperty("userId", "5"); // set userId its a sample here
    int responseCode = conection.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(conection.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {
            response.append(readLine);
        } in .close();
        // print result
        System.out.println("JSON String Result " + response.toString());
        //GetAndPost.POSTRequest(response.toString());
    } else {
        System.out.println("GET NOT WORKED");
    }
}

public static void updateDoctorsFreeslotsPUTRequest() throws IOException {
    
    String id = "6";
    String doctor = "doctor3";
    String start_time = "21";
    String finish_time = "22";
    String status = "available";
    
    
    JSONObject jsonObj = new JSONObject();
    jsonObj.put("id", id);
    jsonObj.put("doctor", doctor);
    jsonObj.put("start_time", start_time);
    jsonObj.put("finish_time", finish_time);
    jsonObj.put("status", status);

    String message = jsonObj.toString();
    System.out.println(message);
    
    URL obj = new URL("http://localhost:3000/doctor_free_slots/6");
    HttpURLConnection putConnection = (HttpURLConnection) obj.openConnection();
    putConnection.setRequestMethod("PUT");
    putConnection.setRequestProperty("Content-Type", "application/json");
    putConnection.setDoOutput(true);
    
    OutputStream os = putConnection.getOutputStream();
    os.write(message.getBytes());
    os.flush();
    os.close();
    
    int responseCode = putConnection.getResponseCode();
    System.out.println("PUT Response Code :  " + responseCode);
    System.out.println("PUT Response Message : " + putConnection.getResponseMessage());
}

public static void addDoctorsFreeslotsPOSTRequest() throws IOException {
      
    String id = "7";
    String doctor = "doctor3";
    String start_time = "23";
    String finish_time = "24";
    String status = "available";
    
    
    JSONObject jsonObj = new JSONObject();
    jsonObj.put("id", id);
    jsonObj.put("doctor", doctor);
    jsonObj.put("start_time", start_time);
    jsonObj.put("finish_time", finish_time);
    jsonObj.put("status", status);

    String message = jsonObj.toString();
    System.out.println(message);
    
   
    URL obj = new URL("http://localhost:3000/doctor_free_slots");
    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
    postConnection.setRequestMethod("POST");
    postConnection.setRequestProperty("Content-Type", "application/json");
    postConnection.setDoOutput(true);
    
    OutputStream os = postConnection.getOutputStream();
    os.write(message.getBytes());
    os.flush();
    os.close();
    
    int responseCode = postConnection.getResponseCode();
    System.out.println("POST Response Code :  " + responseCode);
    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
        BufferedReader in = new BufferedReader(new InputStreamReader(
            postConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
        } in .close();
        // print result
        System.out.println(response.toString());
    } else {
        System.out.println("POST NOT WORKED");
    }
}
    
public static void deleteDoctorsFreeslotsDELETERequest() throws IOException {
    
    
    URL obj = new URL("http://localhost:3000/doctor_free_slots/1");
    HttpURLConnection deleteConnection = (HttpURLConnection) obj.openConnection();
    deleteConnection.setRequestMethod("DELETE");
    deleteConnection.setRequestProperty("Content-Type", "application/json");
    deleteConnection.setRequestProperty("X-HTTP-Method-Override", "DELETE");
    deleteConnection.setDoOutput(false);
    
    int responseCode = deleteConnection.getResponseCode();
    System.out.println("DELETE Response Code :  " + responseCode);
    System.out.println("DELETE Response Message : " + deleteConnection.getResponseMessage());
}
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
      //Test.showAllMedicinesGETRequest(); 
      
    }
    
}
