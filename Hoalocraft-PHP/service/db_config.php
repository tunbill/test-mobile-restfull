<?php
	function getConnection() {
		$dbhost="localhost";
		$dbuser="root";
		$dbpass="123456";
		$dbname="hoalucraft";
		$dbh = new PDO("mysql:host=$dbhost;dbname=$dbname", $dbuser, $dbpass);	
		$dbh -> exec("set names utf8");
		$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		return $dbh;
	}
?>