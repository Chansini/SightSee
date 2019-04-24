<?php
header('Content-type:application/json;charset=utf-8');

$host="localhost"; //replace with your hostname
$username="root"; //replace with your username
$password=""; //replace with your password
$db_name="sightsee"; //replace with your database
//open connection to mysql db
$conn= mysqli_connect($host,$username,$password,$db_name) or die("Error " . mysqli_error($conn));
mysqli_query($conn,'SET CHARACTER SET UTF8');
//fetch table rows from mysql db
$sql = "select * from tb_place";
$result = mysqli_query($conn, $sql) or die("Error in Selecting " . mysqli_error($conn));
//create place array
$placearray = array();
while($row =mysqli_fetch_assoc($result))
{
//add MySQL result to place array
$placearray[] = $row;
}
//Convert PHP array to JSON String
echo json_encode($placearray);
//close the db connection
mysqli_close($conn);
?>