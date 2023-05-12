import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

// 1)	Выбрать любой датасет на kaggle.com
// 2)	Cделать 10 выборок данных по выбранной предметной области

public class Task {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("l10")
                .config("spark.master", "local")
                .getOrCreate();

        Dataset<Row> data = spark.read().format("csv")
                .option("header", "true")
                .load("/home/user/Downloads/archive/anime.csv");

        data.createOrReplaceTempView("anime");

        spark.sql("select name from anime limit 10").show();
        spark.sql("select * from anime where lower(genre) like '%drama%'").show();
        spark.sql("select * from anime where episodes > 20 limit 10").show();
        spark.sql("select * from anime where members > 100000 and episodes > 24").show();
        spark.sql("select * from anime order by rating desc limit 5").show();
        spark.sql("select * from anime order by rating asc limit 5").show();
        spark.sql("select * from anime where lower(genre) like '%action%' order by rating desc limit 10").show();
        spark.sql("select avg(rating) from anime where lower(genre) like '%mecha%'");
        spark.sql("select avg(rating) from anime where lower(genre) like '%ecchi%'");
        spark.sql("select avg(episodes) from anime where lower(name) like '%jojo%'");

        spark.stop();
    }
}
