import java.text.SimpleDateFormat;
import java.util.Date;

public class exam18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date now = new Date();
		SimpleDateFormat sFormat;

		sFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sFormat.format (now)); // 2020-08-14 형식
		sFormat = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sFormat.format(now)); // 06:25:58 형식
	}
}
