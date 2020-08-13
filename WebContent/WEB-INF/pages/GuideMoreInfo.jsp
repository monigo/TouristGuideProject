<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function valthisform()
{
    var checkboxs=document.getElementsByName("freeslots");
    var okay=false;
    for(var i=0,l=checkboxs.length;i<l;i++)
    {
        if(checkboxs[i].checked)
        {
            okay=true;
            break;
        }
    }
    if(!okay)alert("Please check atleast one checkbox");
}

</script>
</head>
<body>
	
<h1>Select free slots</h1>
<h2>Select free time slots when you are available</h2>
<form action="handle_guide_more_info" method="POST" onSubmit="return valthisform(this)">
  <input type="checkbox" id="slot1" name="freeslots" value="0-1">
  <label for="freeslots"> 0-1</label>
  
  <input type="checkbox" id="slot2" name="freeslots" value="1-2">
  <label for="freeslots"> 1-2</label>
  
  <input type="checkbox" id="slot3" name="freeslots" value="2-3">
  <label for="freeslots"> 2-3</label>
  
  <input type="checkbox" id="slot4" name="freeslots" value="3-4">
  <label for="freeslots"> 3-4</label><br><br>
  
  <input type="checkbox" id="slot5" name="freeslots" value="4-5">
  <label for="freeslots"> 4-5</label>
  
  <input type="checkbox" id="slot6" name="freeslots" value="5-6">
  <label for="freeslots"> 5-6</label>
  
  <input type="checkbox" id="slot7" name="freeslots" value="6-7">
  <label for="freeslots"> 6-7</label>
  
  <input type="checkbox" id="slot8" name="freeslots" value="7-8">
  <label for="freeslots"> 7-8</label><br><br>
  
  <input type="checkbox" id="slot9" name="freeslots" value="8-9">
  <label for="freeslots"> 8-9</label>
  
  <input type="checkbox" id="slot10" name="freeslots" value="9-10">
  <label for="freeslots"> 9-10</label>
  
  <input type="checkbox" id="slot11" name="freeslots" value="10-11">
  <label for="freeslots"> 10-11</label>
  
  <input type="checkbox" id="slot12" name="freeslots" value="11-12">
  <label for="freeslots"> 11-12</label><br><br>
  
  <input type="checkbox" id="slot13" name="freeslots" value="12-13">
  <label for="freeslots"> 12-13</label>
  
  <input type="checkbox" id="slot14" name="freeslots" value="13-14">
  <label for="freeslots"> 13-14</label>
  
  <input type="checkbox" id="slot15" name="slot15" value="14-15">
  <label for="freeslots"> 14-15</label>
  
  <input type="checkbox" id="slot16" name="freeslots" value="15-16">
  <label for="freeslots"> 15-16</label><br><br>
  
  <input type="checkbox" id="slot17" name="freeslots" value="16-17">
  <label for="freeslots"> 16-17</label>
  
  <input type="checkbox" id="slot18" name="freeslots" value="17-18">
  <label for="freeslots"> 17-18</label>
  
  <input type="checkbox" id="slot19" name="freeslots" value="18-19">
  <label for="freeslots"> 18-19</label>
  
  <input type="checkbox" id="slot20" name="freeslots" value="19-20">
  <label for="freeslots"> 19-20</label><br><br>
  
  <input type="checkbox" id="slot21" name="freeslots" value="20-21">
  <label for="freeslots"> 20-21</label>
  
  <input type="checkbox" id="slot22" name="freeslots" value="21-22">
  <label for="freeslots"> 21-22</label>
  
  <input type="checkbox" id="slot23" name="freeslots" value="22-23">
  <label for="freeslots"> 22-23</label>
  
  <input type="checkbox" id="slot24" name="freeslots" value="23-24">
  <label for="freeslots"> 23-24</label><br><br>
  
  <input type="submit" value="Submit">
</form>
</body>
</html>