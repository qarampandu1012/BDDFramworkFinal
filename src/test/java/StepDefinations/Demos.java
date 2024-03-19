package StepDefinations;

import java.io.IOException;

import org.openqa.selenium.By;

import Utills.AppUtills;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demos {
	private static final By Dropable = By.xpath("//a[text()='Droppable']");
	private static final By DragElement = By.xpath("//div[@id='draggable']");
	private static final By DropableElement = By.xpath("//div[@id='droppable']");
	private static final By Frame = By.xpath("//iframe[@class='demo-frame']");
	private static final By Demos = By.xpath("//a[text()='Demos']");
	private static final By DatePickerCalenderTextBox = By.xpath("//input[@id='datepicker']");
	private static final By ActualYearText = By.xpath("//span[@class='ui-datepicker-year']");
	private static final By NextButton = By.xpath("//span[text()='Next']");
	private static final By ActualMonthText = By.xpath("//span[@class='ui-datepicker-month']");
	private static final By Table = By.xpath("//table[@class='ui-datepicker-calendar']");
	private static final By CheckBBoxRadio = By.xpath("//a[text()='Checkboxradio']");
	private static final By CheckBBoxRadioButton = By.xpath("//label[text()='New York']");
	private static final By Accordion = By.xpath("//a[text()='Accordion']");
	private static final By AccordionPage = By.xpath("//h1[text()='Accordion']");
	
	///done
	

	AppUtills appUtills = new AppUtills();

	@Given("User Click on {string} Button")
	public void user_click_on_button(String label) throws IOException {

		switch (label) {

		case "Demos":
			appUtills.clickElement(Demos);
			break;

		default:
			System.out.println("There is no Element Object");
			break;

		}
	}

	@Then("User Should see {string}")
	public void user_should_see(String string) throws IOException {

		appUtills.userShouldseeElement(Accordion);

	}

	@When("User Click On {string}")
	public void user_click_on(String label) throws IOException {

		switch (label) {

		case "Droppable":
			appUtills.clickElement(Dropable);
			break;
		case "Checkboxradio":
			appUtills.clickElement(CheckBBoxRadio);
			break;
		case "NewYorkRadioButton":
			appUtills.clickElement(CheckBBoxRadioButton);
			break;

		case "AccordianButton":
			appUtills.clickElement(Accordion);
			break;

		default:
			System.out.println("There is no Element Object");
			break;

		}
	}

	@When("User Should Switch To Frame {string}")
	public void user_should_switch_to_frame(String string) throws IOException {

		appUtills.switchToFrame(Frame);
		
	}

	@When("User Should drag {string}  and drop {string}")
	public void user_should_drag_and_drop(String string, String string2) throws IOException {

		
		appUtills.dragAndDrop(DragElement, DropableElement);
	}

}
