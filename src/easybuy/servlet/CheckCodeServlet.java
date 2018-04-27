package easybuy.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
 // �����漴������
 	private Font getFont() {
 		// ����random�����������������
 		// Random random = new Random();
 		// �����������飬����װ��ͬ�������Font����
 		Font font[] = new Font[1];
 		font[0] = new Font("����", Font.ITALIC, 24);
 		// font[1] = new Font("Antique Olive Compact", Font.PLAIN, 24);
 		// font[2] = new Font("Forte", Font.PLAIN, 24);
 		// font[3] = new Font("Wide Latin", Font.PLAIN, 24);
 		// font[4] = new Font("Gill Sans Ultra Bold", Font.PLAIN, 24);
 		return font[0];
 	}

 	protected void service(HttpServletRequest req, HttpServletResponse resp)
 			throws ServletException, IOException {
 		// ������Ӧͷ Content-type����
 		System.out.println("getimg������");
 		resp.setContentType("image/jpeg");
 		OutputStream os = resp.getOutputStream();
 		int width = 83, height = 30;
 		// ����ָ�������ߺ�BufferedImage����
 		BufferedImage image = new BufferedImage(width, height,
 				BufferedImage.TYPE_INT_RGB);
 		Graphics g = image.getGraphics(); // �û��ʻ���image��
 		Color c = g.getColor(); // ���浱ǰ���ʵ���ɫ
 		// ������
 		g.fillRect(0, 0, width, height);

 		char[] ch = "abcdefghjkmnpqrstuvwxyz2345678901".toCharArray(); // �漴�������ַ���
 																		// 1������1��0(����0)
 		int length = ch.length; // �漴�ַ����ĳ���
 		String sRand = ""; // �����漴�������ַ���
 		Random random = new Random();

 		for (int i = 0; i < 4; i++) {
 			// ��������
 			g.setFont(getFont());
 			// �漴����0-9������
 			String rand = new Character(ch[random.nextInt(length)]).toString();
 			sRand += rand;
 			// ���������ɫ
 			g.setColor(new Color(random.nextInt(255), random.nextInt(255),
 					random.nextInt(255)));
 			g.drawString(rand, 20 * i + 6, 25);
 		}
 		// �����漴���ŵ�
 		for (int i = 0; i < 10; i++) {
 			int x1 = random.nextInt(width);
 			int y1 = random.nextInt(height);
 			g.drawOval(x1, y1, 2, 2);
 		}
 		// �����ʵ���ɫ�����û�ȥ
 		g.setColor(c);
 		// �ͷŴ�ͼ�ε��������Լ���ʹ�õ�����ϵͳ��Դ��
 		g.dispose();

 		// ����֤���¼��session
 		req.getSession().setAttribute("safecode", sRand);
 		// ���ͼ��ҳ��
 		ImageIO.write(image, "JPEG", os);
 		// ��������ر�
 		os.close();
 	}

}