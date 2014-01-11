<?php
require_once '../db_config.php';
require '../Slim/Slim.php';

$app = new Slim();
$app->contentType('text/html charset=utf-8');
$app->get('/categories', 'getCategories');
$app->get('/categories/:lang', 'getCategoriesByLang');
$app->get('/category/:categoryId', 'getCategoryById');

$app->run();

function getCategories() {
	$sql = "SELECT * FROM product_categories WHERE lang='en' AND ORDER BY name";
	
	try {
		$db = getConnection();
		$stmt = $db->query($sql);  
		$categories = $stmt->fetchAll(PDO::FETCH_OBJ);
		$db = null;
		echo '{"category": ' . json_encode($categories) . '}';
	} catch(PDOException $e) {
		echo '{"error":{"text":'. $e->getMessage() .'}}'; 
	}
	
}

function getCategoriesByLang($lang) {
	$sql = "SELECT * FROM product_categories WHERE lang=:lang ORDER BY name";
	try {
		$db = getConnection();
		$stmt = $db->prepare($sql);
		$stmt->bindValue(':lang', $lang);
		$stmt->execute();
		$category = $stmt->fetchAll(PDO::FETCH_OBJ);
	
		$db = null;
		echo '{"category": ' .json_encode($category) . '}';
	} catch (PDOException $e) {
		echo '{"error": {"text":' .$e->getMessage() .'}}'; 
	}
}

function getCategoryById($categoryId) {
	$sql = "SELECT * FROM product_categories WHERE id=:id";
	try {
		$db = getConnection();
		$stmt = $db->prepare($sql);
		$stmt->bindValue(':id', $categoryId);
		$stmt->execute();
		$category = $stmt->fetchAll(PDO::FETCH_OBJ);
	
		$db = null;
		echo '{"category": ' .json_encode($category) . '}';
	} catch (PDOException $e) {
		echo '{"error": {"text":' .$e->getMessage() .'}}'; 
	} 
}

?>