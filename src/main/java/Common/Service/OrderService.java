package Common.Service;


import Common.Dao.MemberDao;
import Common.Dao.OrderDao;
import Common.Dao.ProdDao;
import Common.Dto.OrderDto;
import Common.Dto.ProdDto;

public class OrderService<oDto> {
	
	private OrderDto oDto;
	private ProdDto pDto;
	private MemberService memberService;
	private ProductService productService;
	private OrderDao oDao;
	private MemberDao mDao;
	private ProdDao pDao;
	private static OrderService instance;
	
	
	
	public OrderService getInstance()
	{
		if(instance == null)
		{
			instance = new OrderService();
		}
		return instance;
	}
	
	public OrderService()
	{
		oDao = OrderDao.getInstance();
		mDao = MemberDao.getInstance();
		pDao = ProdDao.getInstance();
		memberService = MemberService.getInstance();
		productService = ProductService.getInstance();
		
	}

	
	


	
	

}