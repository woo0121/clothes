package Common.Service;

import Common.Dao.ProdDao;

public class ProductService {

	private ProdDao dao;

	//singleton
	private static ProductService instance;
	public static ProductService getInstance() {
		if(instance==null)
			instance = new ProductService();
		return instance;
	}

	//
	private MemberService memberService;

	public ProductService() {
		dao = new ProdDao();
		memberService = MemberService.getInstance();
	}


}
