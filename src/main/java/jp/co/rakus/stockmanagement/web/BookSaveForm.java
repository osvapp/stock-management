package jp.co.rakus.stockmanagement.web;

import org.springframework.web.multipart.MultipartFile;

public class BookSaveForm {
	
	/** id  */
	private Integer id;
    /** 書籍名 */
	private String name;
	/** 著者 */
	private String author;
	/** 出版社 */
	private String publisher;
	/** 価格 */
	private int price;
	/** ISBNコード */
	private String isbncode;
	/** 発売日 */
	private String saledate;
	/** 説明 */
	private String explanation;
	/** 画像 */
//	private String image;
//	private Image image;
	private MultipartFile image;
	/** 在庫  */
	private Integer stock;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIsbncode() {
		return isbncode;
	}
	public void setIsbncode(String isbncode) {
		this.isbncode = isbncode;
	}
	public String getSaledate() {
		return saledate;
	}
	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
}
