package org.wildflowers.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.wildflowers.servlet.DBUtilityOK;

/**
 * Servlet implementation class HttpServlet
 */
@WebServlet("/HttpServlet")
public class HttpServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     // @see javax.servlet.http.HttpServlet#javax.servlet.http.HttpServlet()
     */

    public HttpServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String tab_id = request.getParameter("tab_id");

        // create a report
        if (tab_id.equals("0")) {
            System.out.println("A report is submitted!");
            try {
                createObservation(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // query reports
        else if (tab_id.equals("1")) {
            System.out.println("A query is submitted!");
            try {
                queryObservation(request, response);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void createObservation(HttpServletRequest request, HttpServletResponse
            response) throws SQLException, IOException {
        DBUtilityOK dbutil = new DBUtilityOK();
        String sql;

        // 3. create report
        int report_id = 0;
        String county = request.getParameter("county");
        String report_type = request.getParameter("report_type");
        String lon = request.getParameter("longitude");
        String lat = request.getParameter("latitude");
        String scientific_name = request.getParameter("scientific_name");
        String state = request.getParameter("state");
        String date = request.getParameter("date");
        if (county != null) {county = "'" + county + "'";}
        if (report_type != null) {report_type = "'" + report_type + "'";}
        if (scientific_name != null) {scientific_name = "'" + scientific_name + "'";}
        if (state != null) {state = "'" + state + "'";}

        sql = "insert into wildflowers (county, report_type, scientific_name, state, geom)" +
                " values (" + county + "," + report_type + "," + scientific_name
                + "," + state + ", ST_GeomFromText('POINT(" + lon + " " + lat + ")', 4326))";
        dbutil.modifyDB(sql);

        // record report_id
        ResultSet res_3 = dbutil.queryDB("select last_value from wildflowers_id_seq");
        res_3.next();
        report_id = res_3.getInt(1);

        System.out.println("Success! Observation created.");

        // response that the observation submission is successful
        JSONObject data = new JSONObject();
        try {
            data.put("status", "success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        response.getWriter().write(data.toString());

    }

//    private void queryObservation(HttpServletRequest request, HttpServletResponse
//            response) throws JSONException, SQLException, IOException {
//        //create an empty JSON array to pass into the query helper
//        JSONArray list = new JSONArray();
//
//        String report_type = request.getParameter("report_type");
//
//        // select records based on report type (where clause at end of sql statement)
//        if (report_type == null) {
//            String sql = "select id, county, report_type, " +
//                    "scientific_name, ST_X(geom) as " +
//                    "longitude, ST_Y(geom) as latitude from wildflowers where report_type is null";
//            queryObservationHelper(sql,list,null);
//        }
//
//        if (report_type == null || report_type.equalsIgnoreCase("test3")) {
//            String sql = "select id, county, report_type, " +
//                    "scientific_name, ST_X(geom) as " +
//                    "longitude, ST_Y(geom) as latitude from wildflowers where report_type = 'test3'";
//            queryObservationHelper(sql,list,"test3");
//        }
//
//        if (report_type == null || report_type.equalsIgnoreCase("test2")) {
//            String sql = "select id, county, report_type, " +
//                    "scientific_name, ST_X(geom) as " +
//                    "longitude, ST_Y(geom) as latitude from wildflowers where report_type = 'test2'";
//            queryObservationHelper(sql,list,"test2");
//        }
//
//        if (report_type == null || report_type.equalsIgnoreCase("test")) {
//            String sql = "select id, county, report_type, " +
//                    "scientific_name, ST_X(geom) as " +
//                    "longitude, ST_Y(geom) as latitude from wildflowers where report_type = 'test'";
//            queryObservationHelper(sql,list,"test");
//        }
//
//        response.getWriter().write(list.toString());
//    }
//
//    private void queryObservationHelper(String sql, JSONArray list, String report_type) throws SQLException {
//        DBUtilityOK dbutil = new DBUtilityOK();
//
////        if (report_type.equalsIgnoreCase("test")) {
////            System.out.println("test");
////        }
////        else if (report_type.equalsIgnoreCase("test2")) {
////            System.out.println("test2");
////        }
//
//        ResultSet res = dbutil.queryDB(sql);
//        while (res.next()) {
//            // add to response
//            HashMap<String, String> m = new HashMap<String,String>();
//            m.put("wildflowers_id", res.getString("id"));
//            m.put("report_type", res.getString("report_type"));
//            m.put("county", res.getString("county"));
//            m.put("longitude", res.getString("longitude"));
//            m.put("latitude", res.getString("latitude"));
//            list.put(m);
//        }
//    }

    private void queryObservation(HttpServletRequest request, HttpServletResponse
            response) throws JSONException, SQLException, IOException {
        //create an empty JSON array to pass into the query helper
        JSONArray list = new JSONArray();

        String date = request.getParameter("date");

        // select records based on report type (where clause at end of sql statement)
//        if (report_type == null) {
//            String sql = "select id, county, date, " +
//                    "scientific_name, ST_X(geom) as " +
//                    "longitude, ST_Y(geom) as latitude from wildflowers where date is null";
//            queryObservationHelper(sql,list,null);
//        }

        if (date == null || date.equalsIgnoreCase("1800")) {
            String sql = "select id, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where date >= '1800-01-01'";
            queryObservationHelper(sql,list,"1800");
        }

        if (date == null || date.equalsIgnoreCase("1900")) {
            String sql = "select id, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where date >= '1900-01-01'";
            queryObservationHelper(sql,list,"1900");
        }

        if (date == null || date.equalsIgnoreCase("2000")) {
            String sql = "select id, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where date >= '2000-01-01'";
            queryObservationHelper(sql,list,"2000");
        }

        response.getWriter().write(list.toString());
    }

    private void queryObservationHelper(String sql, JSONArray list, String date) throws SQLException {
        DBUtilityOK dbutil = new DBUtilityOK();

//        if (report_type.equalsIgnoreCase("test")) {
//            System.out.println("test");
//        }
//        else if (report_type.equalsIgnoreCase("test2")) {
//            System.out.println("test2");
//        }

        ResultSet res = dbutil.queryDB(sql);
        while (res.next()) {
            // add to response
            HashMap<String, String> m = new HashMap<String,String>();
            m.put("wildflowers_id", res.getString("id"));
            m.put("date", res.getString("date"));
            m.put("county", res.getString("county"));
            m.put("longitude", res.getString("longitude"));
            m.put("latitude", res.getString("latitude"));
            list.put(m);
        }
    }

    public void main() throws JSONException {
    }
}