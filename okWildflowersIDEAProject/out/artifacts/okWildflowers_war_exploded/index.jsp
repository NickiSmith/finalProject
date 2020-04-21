<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Web Project</title>

  <!-- jQuery -->
  <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
  <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

  <!-- Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <!-- Bootstrap Date-Picker Plugin -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

  <!-- Google maps API -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB6Xpbv0WISWCAQWBY05c5ln8P6gPf1Bts&libraries=geometry,places">
  </script>

  <!-- Custom styles -->
  <link rel="stylesheet" href="css/style.css">

</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <a class="navbar-brand">Oklahoma Wildflower Map</a>
</nav>

<div class="container-fluid">
  <div class="row">
    <div class="sidebar col-xs-3">

      <!-- Tab Navis-->
      <ul class="nav nav-tabs">
        <li class="active"><a href="#create_observation" data-toggle="tab">Submit Observation</a></li>
        <li><a href="#query_observation" data-toggle="tab">Query Database</a></li>
      </ul>

      <!-- Tab panes -->
      <div class="tab-content ">
        <!-- Create Report Tab Panel -->
        <div class="tab-pane active" id="create_observation">
          <form id = "create_observation_form">
            <div><label>Date of observation:&nbsp</label><input placeholder="MM/DD/YYYY" name="date" autocomplete="off"></div>

            <div><label>Biome:&nbsp</label><select name="biome">
              <option value=''>Select a region</option>
              <option value='1'>Region 1</option>
              <option value='2'>Region 2</option>
              <option value='3'>Region 3</option>
              <option value='4'>Region 4</option>
              <option value='5'>Region 5</option>
              <option value='6'>Region 6</option>
              <option value='7'>Region 7</option>
            </select></div>
            <div><label>County:</label>
              <select name="county">
                <option value=''>Select a county</option>
                  <option value='Adair'>Adair</option>
                  <option value='Alfalfa'>Alfalfa</option>
                  <option value='Atoka'>Atoka</option>
                  <option value='Beaver'>Beaver</option>
                  <option value='Beckham'>Beckham</option>
                  <option value='Blaine'>Blaine</option>
                  <option value='Bryan'>Bryan</option>
                  <option value='Caddo'>Caddo</option>
                  <option value='Canadian'>Canadian</option>
                  <option value='Carter'>Carter</option>
                  <option value='Cherokee'>Cherokee</option>
                  <option value='Choctaw'>Choctaw</option>
                  <option value='Cimarron'>Cimarron</option>
                  <option value='Cleveland'>Cleveland</option>
                  <option value='Coal'>Coal</option>
                  <option value='Comanche'>Comanche</option>
                  <option value='Cotton'>Cotton</option>
                  <option value='Craig'>Craig</option>
                  <option value='Creek'>Creek</option>
                  <option value='Custer'>Custer</option>
                  <option value='Delaware'>Delaware</option>
                  <option value='Dewey'>Dewey</option>
                  <option value='Ellis'>Ellis</option>
                  <option value='Garfield'>Garfield</option>
                  <option value='Garvin'>Garvin</option>
                  <option value='Grady'>Grady</option>
                  <option value='Grant'>Grant</option>
                  <option value='Greer'>Greer</option>
                  <option value='Harmon'>Harmon</option>
                  <option value='Harper'>Harper</option>
                  <option value='Haskell'>Haskell</option>
                  <option value='Hughes'>Hughes</option>
                  <option value='Jackson'>Jackson</option>
                  <option value='Jefferson'>Jefferson</option>
                  <option value='Johnston'>Johnston</option>
                  <option value='Kay'>Kay</option>
                  <option value='Kingfisher'>Kingfisher</option>
                  <option value='Kiowa'>Kiowa</option>
                  <option value='Latimer'>Latimer</option>
                  <option value='Le Flore'>Le Flore</option>
                  <option value='Lincoln'>Lincoln</option>
                  <option value='Logan'>Logan</option>
                  <option value='Love'>Love</option>
                  <option value='McClain'>McClain</option>
                  <option value='McCurtain'>McCurtain</option>
                  <option value='McIntosh'>McIntosh</option>
                  <option value='Major'>Major</option>
                  <option value='Marshall'>Marshall</option>
                  <option value='Mayes'>Mayes</option>
                  <option value='Murray'>Murray</option>
                  <option value='Muskogee'>Muskogee</option>
                  <option value='Noble'>Noble</option>
                  <option value='Nowata'>Nowata</option>
                  <option value='Okfuskee'>Okfuskee</option>
                  <option value='Oklahoma'>Oklahoma</option>
                  <option value='Okmulgee'>Okmulgee</option>
                  <option value='Osage'>Osage</option>
                  <option value='Ottawa'>Ottawa</option>
                  <option value='Pawnee'>Pawnee</option>
                  <option value='Payne'>Payne</option>
                  <option value='Pittsburg'>Pittsburg</option>
                  <option value='Pontotoc'>Pontotoc</option>
                  <option value='Pottawatomie'>Pottawatomie</option>
                  <option value='Pushmataha'>Pushmataha</option>
                  <option value='Roger Mills'>Roger Mills</option>
                  <option value='Rogers'>Rogers</option>
                  <option value='Seminole'>Seminole</option>
                  <option value='Sequoyah'>Sequoyah</option>
                  <option value='Stephens'>Stephens</option>
                  <option value='Texas'>Texas</option>
                  <option value='Tillman'>Tillman</option>
                  <option value='Tulsa'>Tulsa</option>
                  <option value='Wagoner'>Wagoner</option>
                  <option value='Washington'>Washington</option>
                  <option value='Washita'>Washita</option>
                  <option value='Woods'>Woods</option>
                  <option value='Woodward'>Woodward</option>
              </select>
              <div><label>Genus:&nbsp</label><input placeholder="genus" name="genus"></div>
              <div><label>Common name:&nbsp</label><input placeholder="Common name (required)" name="common_name" required></div>
              <div><label>Scientific name&nbsp</label><input placeholder="Scientific name" name="scientific_name"></div>
              <div><label>Habitat:&nbsp</label><input id="habitat" placeholder="Description (max 500 characters)" name="habitat" maxlength="500"></div>
              <div><label>Recorded by:&nbsp</label><input placeholder="Your name" name="recorded_by"></div>
            </div>
            <div><label>Address:</label>
              <input id="autocomplete" placeholder="Address" >
            </div>
            <button type="submit" class="btn btn-default" id="report_submit_btn">
              <span class="glyphicon glyphicon-star"></span> Submit
            </button>
          </form>
        </div>

        <!-- Query Report Tab Panel: dropdowns are populated by main.js -->
        <div class="tab-pane" id="query_observation">
          <form id = "query_observation_form">

                <div><label>Genus:</label>
                    <select id="genus" name="genus">
                      <option value="">Choose the genus</option>
                      <option value="Achillea">Achillea</option>
                      <option value="Aphanostephus">Aphanostephus</option>
                      <option value="Asclepias">Asclepias</option>
                      <option value="Castilleja">Castilleja</option>
                      <option value="Coreopsis">Coreopsis</option>
                      <option value="Echinacea">Echinacea</option>
                      <option value="Gaillardia">Gaillardia</option>
                      <option value="Phlox">Phlox</option>
                      <option value="Trifolium">Trifolium</option>
                    </select>
                </div>

                <div><label>Common name:</label>
                  <select id="common_name" name="common">
                    <option value="">Choose the common name</option>
                    <option value="antelopehorns">antelopehorns</option>
                    <option value="Arkansas dozedaisy">Arkansas dozedaisy</option>
                    <option value="blacksamson echinacea">blacksamson echinacea</option>
                    <option value="broadleaf milkweed">broadleaf milkweed</option>
                    <option value="buffalo clover">buffalo clover</option>
                    <option value="Bush_s purple coneflower">Bush's purple coneflower</option>
                    <option value="butterfly milkweed">butterfly milkweed</option>
                    <option value="clasping milkweed">clasping milkweed</option>
                    <option value="crimson clover">crimson clover</option>
                    <option value="downy paintedcup">downy paintedcup</option>
                    <option value="eastern purple coneflower">eastern purple coneflower</option>
                    <option value="Engelmann_s milkweed">Engelmann's milkweed</option>
                    <option value="entireleaf Indian paintbrush">entireleaf Indian paintbrush</option>
                    <option value="fourleaf milkweed">fourleaf milkweed</option>
                    <option value="golden tickseed">golden tickseed</option>
                    <option value="green antelopehorn">green antelopehorn</option>
                    <option value="green comet milkweed">green comet milkweed</option>
                    <option value="green milkweed">green milkweed</option>
                    <option value="Hairy dozedaisy">hairy dozedaisy</option>
                    <option value="Indian blanket">Indian blanket</option>
                    <option value="lanceleaf blanketflower">lanceleaf blanketflower</option>
                    <option value="largeflower tickseed">largeflower tickseed</option>
                    <option value="longhair phlox">longhair phlox</option>
                    <option value="Oklahoma phlox">Oklahoma phlox</option>
                    <option value="pale purple coneflower">pale purple coneflower</option>
                    <option value="perfumeballs">perfumeballs</option>
                    <option value="Plains dozedaisy">plains dozedaisy</option>
                    <option value="plains milkweed">plains milkweed</option>
                    <option value="prairie Indian paintbrush">prairie Indian paintbrush</option>
                    <option value="red dome blanketflower">red dome blanketflower</option>
                    <option value="rough coneflower">rough coneflower</option>
                    <option value="sand milkweed">sand milkweed</option>
                    <option value="sanguine purple coneflower">sanguine purple coneflower</option>
                    <option value="showy milkweed">showy milkweed</option>
                    <option value="sleepy silene">sleepy silene</option>
                    <option value="star tickseed">star tickseed</option>
                    <option value="stiff tickseed">stiff tickseed</option>
                    <option value="strigose blacksamson">strigose blacksamson</option>
                    <option value="swamp milkweed">swamp milkweed</option>
                    <option value="tall tickseed">tall tickseed</option>
                    <option value="Topeka purple coneflower">Topeka purple coneflower</option>
                    <option value="white clover">white clover</option>
                    <option value="whorled milkweed">whorled milkweed</option>
                  </select>
                </div>

                <div><label>Biome:</label>
                  <select id="biome" name="biome">
                                <option value="">Choose the biome region</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                  </select>
                </div>

                <div><label>County:</label>
                  <select id="county_auto" name="county">
                    <option value="">Choose the county</option>
                    <option value='Adair'>Adair</option>
                    <option value='Alfalfa'>Alfalfa</option>
                    <option value='Atoka'>Atoka</option>
                    <option value='Beaver'>Beaver</option>
                    <option value='Beckham'>Beckham</option>
                    <option value='Blaine'>Blaine</option>
                    <option value='Bryan'>Bryan</option>
                    <option value='Caddo'>Caddo</option>
                    <option value='Canadian'>Canadian</option>
                    <option value='Carter'>Carter</option>
                    <option value='Cherokee'>Cherokee</option>
                    <option value='Choctaw'>Choctaw</option>
                    <option value='Cimarron'>Cimarron</option>
                    <option value='Cleveland'>Cleveland</option>
                    <option value='Coal'>Coal</option>
                    <option value='Comanche'>Comanche</option>
                    <option value='Cotton'>Cotton</option>
                    <option value='Craig'>Craig</option>
                    <option value='Creek'>Creek</option>
                    <option value='Custer'>Custer</option>
                    <option value='Delaware'>Delaware</option>
                    <option value='Dewey'>Dewey</option>
                    <option value='Ellis'>Ellis</option>
                    <option value='Garfield'>Garfield</option>
                    <option value='Garvin'>Garvin</option>
                    <option value='Grady'>Grady</option>
                    <option value='Grant'>Grant</option>
                    <option value='Greer'>Greer</option>
                    <option value='Harmon'>Harmon</option>
                    <option value='Harper'>Harper</option>
                    <option value='Haskell'>Haskell</option>
                    <option value='Hughes'>Hughes</option>
                    <option value='Jackson'>Jackson</option>
                    <option value='Jefferson'>Jefferson</option>
                    <option value='Johnston'>Johnston</option>
                    <option value='Kay'>Kay</option>
                    <option value='Kingfisher'>Kingfisher</option>
                    <option value='Kiowa'>Kiowa</option>
                    <option value='Latimer'>Latimer</option>
                    <option value='Le Flore'>Le Flore</option>
                    <option value='Lincoln'>Lincoln</option>
                    <option value='Logan'>Logan</option>
                    <option value='Love'>Love</option>
                    <option value='McClain'>McClain</option>
                    <option value='McCurtain'>McCurtain</option>
                    <option value='McIntosh'>McIntosh</option>
                    <option value='Major'>Major</option>
                    <option value='Marshall'>Marshall</option>
                    <option value='Mayes'>Mayes</option>
                    <option value='Murray'>Murray</option>
                    <option value='Muskogee'>Muskogee</option>
                    <option value='Noble'>Noble</option>
                    <option value='Nowata'>Nowata</option>
                    <option value='Okfuskee'>Okfuskee</option>
                    <option value='Oklahoma'>Oklahoma</option>
                    <option value='Okmulgee'>Okmulgee</option>
                    <option value='Osage'>Osage</option>
                    <option value='Ottawa'>Ottawa</option>
                    <option value='Pawnee'>Pawnee</option>
                    <option value='Payne'>Payne</option>
                    <option value='Pittsburg'>Pittsburg</option>
                    <option value='Pontotoc'>Pontotoc</option>
                    <option value='Pottawatomie'>Pottawatomie</option>
                    <option value='Pushmataha'>Pushmataha</option>
                    <option value='Roger Mills'>Roger Mills</option>
                    <option value='Rogers'>Rogers</option>
                    <option value='Seminole'>Seminole</option>
                    <option value='Sequoyah'>Sequoyah</option>
                    <option value='Stephens'>Stephens</option>
                    <option value='Texas'>Texas</option>
                    <option value='Tillman'>Tillman</option>
                    <option value='Tulsa'>Tulsa</option>
                    <option value='Wagoner'>Wagoner</option>
                    <option value='Washington'>Washington</option>
                    <option value='Washita'>Washita</option>
                    <option value='Woods'>Woods</option>
                    <option value='Woodward'>Woodward</option>
                  </select>
                </div>
            <div>
              <label>Start Date:</label>
              <input placeholder="MM/DD/YYYY" name="start_date" autocomplete="off">
            </div>
            <div>
              <label>End Date:</label>
              <input placeholder="MM/DD/YYYY" name="end_date" autocomplete="off">
            </div>

              <button type="submit" class="btn btn-default">
                <span class="glyphicon glyphicon-star"></span> Submit the query
              </button>

            </form>

          </div>
        </div>
      <div>
        <img src="img/okregions.png" height="225" width="350">
      </div>
      </div>

    <div id="map-canvas" class="col-xs-9"></div>

  </div>
</div>



<script src="js/loadformOK.js"></script>
<script src="js/loadmapOK.js"></script>
<script src="js/main.js"></script>

</body>
</html>