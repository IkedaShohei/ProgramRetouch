package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 購入履歴画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/UserBuyHistoryDetail")
public class UserBuyHistoryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**文字化け防止**/
		request.setCharacterEncoding("UTF-8");

		// URLからGETパラメータとしてIDを受け取る
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);


		request.getRequestDispatcher(EcHelper.USER_BUY_HISTORY_DETAIL_PAGE).forward(request, response);

	}
}
