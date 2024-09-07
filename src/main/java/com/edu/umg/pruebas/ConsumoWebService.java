/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.umg.pruebas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;

public class ConsumoWebService {
    public static void main(String[] args) {
        try {
            String url = "http://localhost:8080/WSUMG1/webresources/WSUMG/pruebaUMG";
            
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
         
            con.setRequestMethod("GET");
                      
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
                
            // Convertir a JSON
            JSONObject jsonResponse = (JSONObject) new org.json.simple.parser.JSONParser().parse(response.toString());
                
            // Extraer el nombre y el apellido
            String nombre = (String) jsonResponse.get("Nombre");
            String apellido = (String) jsonResponse.get("Apellido");
                
            // Mostrar en consola
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellido: " + apellido);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

