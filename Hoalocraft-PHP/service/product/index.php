<?php
require_once '../db_config.php';
require '../Slim/Slim.php';

$app = new Slim();

$app->contentType('text/html charset=utf-8');
$app->get('/products/:categoryId/:lang/:start/:count', 'getProductsByCategoryId');
$app->get('/product/:productId/:lang', 'getProductsById');
$app->get('/count/:categoryId/:lang', 'countByCategoryId');
$app->run();

function getProductsByCategoryId($categoryId, $lang, $start, $count) {
	$sql = "SELECT * FROM products WHERE product_category_id=:categoryId AND lang=:lang ORDER BY name LIMIT :start, :count;";

	try {
		$db = getConnection();
		$stmt = $db->prepare($sql);
		$stmt->bindValue(':categoryId', intval($categoryId), PDO::PARAM_INT);
		$stmt->bindValue(':lang', $lang);
		$stmt->bindValue(':start', intval($start), PDO::PARAM_INT);
		$stmt->bindValue(':count', intval($count), PDO::PARAM_INT);
		$stmt->execute();
		$category = $stmt->fetchAll(PDO::FETCH_OBJ);

		$db = null;
		echo '{"product": ' .json_encode($category) . '}';
	} catch (PDOException $e) {
		echo '{"error": {"text":' .$e->getMessage() .'}}';
	}
}


function getProductsById($productId, $lang) {
	$sql = "SELECT * FROM products WHERE id=:id AND lang=:lang";
	try {
		$db = getConnection();
		$stmt = $db->prepare($sql);
		$stmt->bindValue(':id', intval($productId), PDO::PARAM_INT);
		$stmt->bindValue(':lang', $lang);
		$stmt->execute();
		$category = $stmt->fetchAll(PDO::FETCH_OBJ);

		$db = null;
		echo '{"product": ' .json_encode($category) . '}';
	} catch (PDOException $e) {
		echo '{"error": {"text":' .$e->getMessage() .'}}';
	}
}

function countByCategoryId($categoryId, $lang) {
	$sql = "SELECT COUNT(*) as count FROM products WHERE product_category_id=:categoryId AND lang=:lang;";

	try {
		$db = getConnection();
		$stmt = $db->prepare($sql);
		
		$stmt->bindValue(':categoryId', intval($categoryId), PDO::PARAM_INT);
		$stmt->bindValue(':lang', $lang);
		
		$stmt->execute();
		$count = $stmt->fetchColumn(0);
		
		$db = null;
		
		echo '{"count":' . json_encode($count) ."}";
	} catch (PDOException $e) {
		echo '{"error": {"text":' .$e->getMessage() .'}}';
	}
}
?>
