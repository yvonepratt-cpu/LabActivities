<?php
class Student{
	private $name;
	private $course;
	private $year;

	function setData($n,$c,$y){
		$this->name = $n;
		$this->course = $c;
		$this->year = $y;
	}

	function showData(){
		echo "<h3>Student Info</h3>";
		echo "Name: ".$this->name."<br>";
		echo "Course: ".$this->course."<br>";
		echo "Year Level: ".$this->year;
	}
}
?>

<html>
<head>
	<title>Student Info</title>
</head>
<body>

<h3>Enter Student Details</h3>
<form method="post">
	Name: <input type="text" name="txtName"><br><br>
	Course: <input type="text" name="txtCourse"><br><br>
	Year Level: <input type="text" name="txtYear"><br><br>
	<input type="submit" name="btnSubmit" value="Submit">
</form>

<?php
if(isset($_POST['btnSubmit'])){
	$stud = new Student();
	$stud->setData($_POST['txtName'], $_POST['txtCourse'], $_POST['txtYear']);
	$stud->showData();
}
?>

</body>
</html>