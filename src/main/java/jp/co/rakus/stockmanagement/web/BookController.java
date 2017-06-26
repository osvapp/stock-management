package jp.co.rakus.stockmanagement.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.stockmanagement.domain.Book;
import jp.co.rakus.stockmanagement.service.BookService;

/**
 * 書籍関連処理を行うコントローラー.
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/book")
@Transactional
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	@Autowired
	private ServletContext context;
	
	/**
	 * フォームを初期化します.
	 * @return フォーム
	 */
	@ModelAttribute
	public BookForm setUpForm() {
		return new BookForm();
	}
	/**
	 * フォームを初期化します
	 * @return　フォーム
	 */
	@ModelAttribute
	public BookSaveForm setUpForm2() {
		return new BookSaveForm();
	}
	
	/**
	 * 書籍リスト情報を取得し書籍リスト画面を表示します.
	 * @param model モデル
	 * @return 書籍リスト表示画面
	 */
	@RequestMapping(value = "list")
	public String list(Model model) {
		logger.debug("書籍の全件検索開始");
		List<Book> bookList = bookService.findAll();
		logger.debug("書籍の全件検索完了");
		model.addAttribute("bookList", bookList);
		return "book/list";
	}
	
	/**
	 * 書籍詳細情報を取得し書籍詳細画面を表示します.
	 * @param id 書籍ID
	 * @param model　モデル
	 * @return　書籍詳細画面
	 */
	@RequestMapping(value = "show/{bookId}")
	public String show(@PathVariable("bookId") Integer id, Model model) {
		logger.debug("書籍の1件検索開始");
		Book book = bookService.findOne(id);
		logger.debug("書籍の1件検索完了");
		model.addAttribute("book", book);
		return "book/show";
	}
	
	/**
	 * 書籍更新を行います.
	 * @param form フォーム
	 * @param result リザルト情報
	 * @param model　モデル
	 * @return　書籍リスト画面
	 */
	@RequestMapping(value = "update")
	public String update(@Validated BookForm form, BindingResult result, Model model) {
		logger.debug("書籍の更新を行います");
		
		if (result.hasErrors()) {
			logger.debug("DBに一致する書籍がありませんでした");
			return show(form.getId(), model);
		}
		
		Book book = bookService.findOne(form.getId());
		book.setStock(form.getStock());
		bookService.update(book);
		logger.debug("書籍の更新を完了しました");
		return list(model);
	}
	
	
	/**
	 * 書籍情報の追加を行います
	 * @param form　フォーム
	 * @param result　リザルト
	 * @param model　モデル
	 * @return　書籍一覧画面
	 */
	@RequestMapping("/save")
	public String save(@Validated BookSaveForm form,BindingResult result,Model model){
		
		Book book = new Book();
		BeanUtils.copyProperties(form, book);

		//発売日の処理
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try{
			book.setSaledate(sdf.parse(form.getSaledate()));
		}catch (Exception e) {
			System.out.println("セーブ失敗");
			return list(model);
		}
		
		//画像ファイルの処理
		try{
			String filepath = context.getRealPath("/img") + form.getImage().getOriginalFilename();
			File uploadFile = new File(filepath + form.getImage().getOriginalFilename());
	        
			form.getImage().transferTo(uploadFile);
			
	        book.setImage(form.getImage().getOriginalFilename());
	        
	        //セーブ
	        bookService.save(book);
			 
		}catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return list(model);
		}
		return list(model);
	}
	
	
	@RequestMapping("/add")
	public String add(){
		return "/book/save";
	}

}
