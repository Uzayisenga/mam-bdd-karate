package com.mamcom_BDDSpring.JsonObjectGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mamcom_BDDSpring.DataModel_API_Request.*;
import com.mamcom_BDDSpring.GlobalFunctions.GlobalFunctions;
import com.mamcom_BDDSpring.annotations.LazyAutowired;
import com.mamcom_BDDSpring.annotations.PageObjects;
import com.mamcom_BDDSpring.dataProvider.SampleSecound;
import com.mamcom_BDDSpring.dataProvider.memberStatus;
import com.mamcom_BDDSpring.dataProvider.updateUser;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@PageObjects
public class JsonObjectGenerator {

    @LazyAutowired
    private com.mamcom_BDDSpring.dataProvider.SampleSecound SampleSecound;

    @LazyAutowired
    private memberStatus memberStatus;

    @LazyAutowired
    private Enrolment enrolment;

    @LazyAutowired
    private GlobalFunctions globalFunctions;

    @LazyAutowired
    private com.mamcom_BDDSpring.dataProvider.updateUser updateUser;

    @LazyAutowired
    private com.mamcom_BDDSpring.dataProvider.Member member;

    String json = "";

    public String getEnrolmentJsonBody(Enrolment enrolment) {
        ObjectMapper objectMapper = new ObjectMapper(  );
        try {
            json = objectMapper.writeValueAsString( enrolment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String getEnrolmentJsonBody(EnrolmentTravelIdTEV enrolmentTravelIdTEV) {
        ObjectMapper objectMapper = new ObjectMapper(  );
        try {
            json = objectMapper.writeValueAsString( enrolmentTravelIdTEV);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String getEnrolmentJsonBody(EnrolmentPayloadForTravelIdUser enrolmentPayloadForTravelIdUser) {
        ObjectMapper objectMapper = new ObjectMapper(  );
        try {
            json = objectMapper.writeValueAsString( enrolment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String getEnrolmentJsonBody(BasicUserEnrolment basicUserEnrolment) {
        ObjectMapper objectMapper = new ObjectMapper(  );
        try {
            json = objectMapper.writeValueAsString( basicUserEnrolment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


    public String getEnrolmentJsonBody(UDHEnrolment udhEnrolment)  {

        try {
          ObjectMapper mapper = new ObjectMapper();
//      //Converting the Object to JSONString
      json = mapper.writeValueAsString(udhEnrolment);

//            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//             json = ow.writeValueAsString(udhEnrolment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String getJsonBody(HashMap<String, Object> jsonbody) {
        ObjectMapper objectMapper = new ObjectMapper(  );
        try {
            json = objectMapper.writeValueAsString( jsonbody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public HashMap<String, Object> updateStatus_Json(){
        memberStatus.setSerialNumber(globalFunctions.getRandomNumber(10));
        HashMap<String, Object> map = new HashMap<>();
        map.put("clientProcessingNumber", memberStatus.getClientProcessingNumber());
        map.put("flightNr", memberStatus.getFlightNr());
        map.put("flightDate",memberStatus.getFlightDate());
        map.put("origin", memberStatus.getOrigin());
        map.put("destination", memberStatus.getDestination());
        map.put("partnerCode", memberStatus.getPartnerCode());
        map.put("serialNumber", memberStatus.getSerialNumber());
        map.put("airlineCode", memberStatus.getAirlineCode());
        String ticketName = enrolment.getLastName()+"/"+enrolment.getFirstName();
        map.put("ticketName", ticketName);
        map.put("bookingClass", memberStatus.getBookingClass());
        return map;
    }
    public HashMap<String, Object> updateStatus(){
        memberStatus.setSerialNumber(globalFunctions.getRandomNumber(10));
        HashMap<String, Object> map = new HashMap<>();
        map.put("clientProcessingNumber", memberStatus.getClientProcessingNumber());
        map.put("flightNr", memberStatus.getFlightNr());
        map.put("flightDate",memberStatus.getFlightDate());
        map.put("origin", memberStatus.getOrigin());
        map.put("destination", memberStatus.getDestination());
        map.put("partnerCode", memberStatus.getPartnerCode());
        map.put("serialNumber", memberStatus.getSerialNumber());
        map.put("airlineCode", memberStatus.getAirlineCode());
        String ticketName = enrolment.getLastName()+"/"+enrolment.getFirstName();
        map.put("ticketName", ticketName);
        map.put("bookingClass", memberStatus.getBookingClass());
        return map;
    }

    public HashMap<String, Object> userupdate_Json(){
        ArrayList<Map> enrolmentAliases = new ArrayList<Map>();
//        ArrayList<updateUser> aliases = new ArrayList<updateUser>(  );
        HashMap<String, Object> map = new HashMap<>();

//        enrolmentAliases.add(updateUser.)
//        map.put("id", updateUser.getId());
//        map.put("type", updateUser.getType());
//        map.put("aliasName",updateUser.getAliasName());
//        map.put("password", updateUser.getPassword());
        map.put("aliases",SampleSecound.getAliases());
        return map;

    }
    public Object getEnrolmentJsonBody(EnrolmentFFP enrolmentFFP) {

        ObjectMapper objectMapper = new ObjectMapper(  );
        try {
            json = objectMapper.writeValueAsString( enrolmentFFP);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public Object getEnrolmentJsonBody(ResetPinPassword resetPinPassword) {

        ObjectMapper objectMapper = new ObjectMapper(  );
        try {
            json = objectMapper.writeValueAsString( resetPinPassword);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public Object getEnrolmentJsonBody(EnrolmentTEV enrolmentTEV) {

        ObjectMapper objectMapper = new ObjectMapper(  );
        try {
            json = objectMapper.writeValueAsString( enrolmentTEV);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public HashMap<String, Object> create_2FABody(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("twoFactorAuthAddressId", member.getMobileId());
        return map;
    }

    public HashMap<String, Object> createAllInOneBody()
    {
        HashMap<String, Object> map = new HashMap<>();
        map.put("permitted",true);
        return map;
    }

}