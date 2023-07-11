package arukikata;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;

public class ArukikataDataGetter {
	
	public ArrayList<DataBean> getData() {
		ArukikataDao dao = new ArukikataDao();
		ArrayList<DataBean> beanList = dao.selectData();
		
		try {
			for (DataBean bean : beanList) {
				ArrayList<File> imageList = new ArrayList<>();
				imageList.add(new File(bean.getPath()));
				imageList.add(new File(bean.getInfo_path()));
				ArrayList<String> strList = new ArrayList<>();
				for(File image : imageList) {
					byte[] data = Files.readAllBytes(image.toPath());
					String base64str = Base64.getEncoder().encodeToString(data);
					
					strList.add(base64str);
				}
				bean.setImage(strList.get(0));
				bean.setInfo_image(strList.get(1));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return beanList;
	}
}
