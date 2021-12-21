package com.webchat.page;

import com.webchat.core.AppBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * @author w29530
 * @date 2021/12/15
 * @desc 通讯录页面
 */
public class ContactPage extends AppBasePage {

	public ContactPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}


	//======================================添加成员============================================
	@AndroidFindBy(xpath = "//*[@text=\"添加成员\"]")
	private WebElement addMemberBtn;

	@AndroidFindBy(xpath = "//*[@text=\"手动输入添加\"]")
	private WebElement manuallyAddBtn;

	@AndroidFindBy(id="com.tencent.wework:id/j2v")
	private WebElement completeInput;

	@AndroidFindBy(xpath = "//*[@text=\"姓名 \"]/..//*[@resource-id=\"com.tencent.wework:id/bf7\"]")
	private WebElement name;

	@AndroidFindBy(id = "com.tencent.wework:id/gge")
	private WebElement phone;

	@AndroidFindBy(uiAutomator = "resourceId(\"com.tencent.wework:id/bfz\").text(\"设置部门\")")
	private WebElement setDepartBtn;

	@AndroidFindBy(xpath = "//*[@text=\"测试\"]/../../..//*[@resource-id=\"com.tencent.wework:id/hp3\"]")
	private WebElement childDepart;

	@AndroidFindBy(id = "com.tencent.wework:id/hp1")
	private WebElement confirmBtn;

	@AndroidFindBy(id = "com.tencent.wework:id/am4")
	private WebElement saveBtn;

	@AndroidFindBy(id = "com.tencent.wework:id/j2e")
	private WebElement backBtn;

	@AndroidFindBy(id = "com.tencent.wework:id/g3f")
	private WebElement noticeSelected;

	//======================================添加成员============================================

	// ======================================搜索成员并编辑============================================

	@AndroidFindBy(id = "com.tencent.wework:id/i6n")
	private WebElement searchBtn;

	@AndroidFindBy(id = "com.tencent.wework:id/gpg")
	private WebElement searchInput;

	@AndroidFindBy(id = "com.tencent.wework:id/dns")
	private WebElement searchResult;

	@AndroidFindBy(id = "com.tencent.wework:id/i6d")
	private WebElement selectBtn;

	@AndroidFindBy(id = "com.tencent.wework:id/b_x")
	private WebElement editBtn;

	@AndroidFindBy(id = "com.tencent.wework:id/elq")
	private WebElement genderSelect;

	@AndroidFindBy(xpath = "//*[@text=\"男\"]")
	private WebElement manSelect;

	@AndroidFindBy(xpath = "//*[@text=\"删除成员\"]")
	private WebElement deleteMemberBtn;

	@AndroidFindBy(id = "com.tencent.wework:id/blx")
	private WebElement confirmDeleteBtn;

	@AndroidFindBy(xpath = "//*[@class='android.widget.Toast']")
	private WebElement toast;

	/**
	 * 添加成员
	 * @param username	用户名
	 * @param userPhone		手机号
	 * @return	ContactPage
	 */
	public ContactPage addMember(String username, String userPhone){
		click(addMemberBtn);
		click(manuallyAddBtn);
//		click(completeInput);
		inputText(name, username);
		inputText(phone, userPhone);
		click(setDepartBtn);
		click(childDepart);
		click(confirmBtn);
		inputText(noticeSelected,"false");
		click(saveBtn);
		return this;
	}

	public ContactPage searchEditMember(String searchName){
		click(searchBtn);
		inputText(searchInput, searchName);
		click(searchResult);
		click(selectBtn);
		click(editBtn);
		click(genderSelect);
		click(manSelect);
		click(saveBtn);
		return this;
	}

	public ContactPage deleteMember(String searchName){
		click(searchBtn);
		inputText(searchInput, searchName);
		click(searchResult);
		click(selectBtn);
		click(editBtn);
		click(deleteMemberBtn);
		click(confirmDeleteBtn);

		return this;
	}

	public String getToast(){
		return toast.getText();
	}
}
