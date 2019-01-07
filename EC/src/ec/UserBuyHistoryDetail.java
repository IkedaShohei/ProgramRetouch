package ec;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BuyDataBeans;
import beans.ItemDataBeans;
import dao.BuyDAO;
import dao.BuyDetailDAO;

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
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);


		try {
			BuyDataBeans buyDataBeans = BuyDAO.getBuyDataBeansByBuyId(id1);

			/**セット**/
			request.setAttribute("buyDataBeans", buyDataBeans);

		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		try {
			ArrayList<ItemDataBeans> buyDetailItemList = BuyDetailDAO.getItemDataBeansListByBuyId(id1);

			/**セット**/
			request.setAttribute("buyDetailItemList", buyDetailItemList);

			/**フォワード**/
			request.getRequestDispatcher(EcHelper.USER_BUY_HISTORY_DETAIL_PAGE).forward(request, response);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}





	}
}
