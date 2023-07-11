package arukikata;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataBean {
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("explanation")
	private String explanation;
	
	@JsonProperty("latitude")
	private double latitude;
	
	@JsonProperty("longitude")
	private double longitude;
	
	@JsonProperty("path")
	private String path;
	
	@JsonProperty("info_name")
	private String info_name;
	
	@JsonProperty("info_path")
	private String info_path;
	
	@JsonProperty("ex_detail")
	private String ex_detail;
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("info_image")
	private String info_image;

	public void setName(String name) {
		this.name = name;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setInfo_name(String info_name) {
		this.info_name = info_name;
	}

	public void setInfo_path(String info_path) {
		this.info_path = info_path;
	}

	public void setEx_detail(String ex_detail) {
		this.ex_detail = ex_detail;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setInfo_image(String info_image) {
		this.info_image = info_image;
	}

	public String getPath() {
		return path;
	}

	public String getInfo_path() {
		return info_path;
	}
}
