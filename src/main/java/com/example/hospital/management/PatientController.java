package com.example.hospital.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    HashMap<Integer, Patient> patientDb = new HashMap<>();

    //using request Params
    @PostMapping("/addPatientViaParameter")
    public String addPatient(@RequestParam("patientId")Integer patientId, @RequestParam("name")String name,
                             @RequestParam("age")Integer age, @RequestParam("disease")String disease){


        Patient patient = new Patient(patientId, name, age, disease);
        patientDb.put(patientId, patient);

        return "Patient added successfully";
    }


    //using request body
    @PostMapping("/addPatientViaRequestBody")
    public String addPatient(@RequestBody Patient patient){

        int key = patient.getPatientId();
        patientDb.put(key, patient);
        return "Patient added successfully";
    }

    @GetMapping("/getPatientInfo")
    public Patient getPatient(@RequestParam("patientId")Integer patientId){
        Patient patient = patientDb.get(patientId);

        return patient;
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients(){

        List<Patient> patients = new ArrayList<>();

        for(Patient p : patientDb.values()){
            patients.add(p);
        }
        return patients;
    }
}
