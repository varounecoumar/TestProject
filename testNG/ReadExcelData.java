package testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {

	private InputStream oFileReader;
	private Workbook oExcelWorkbook;
	private String sExcelFileName;
	
	public String[][] createDataArray(String sFileName, String sSheetName){
		String[][] dataArray = null;
		openExcelWorkbook(sFileName);
		int ci, cj;
		int rows = getRowCountOfSheet(sSheetName);
		int cells = getCellCount(sSheetName, 1);
		dataArray = new String[rows][cells];
		ci=0;
		 
		   for (int i=1; i<=rows; i++, ci++) {           	   

			  cj=0;

			   for (int j=1;j<=cells;j++, cj++){

				   dataArray[ci][cj]=getCellData(sSheetName, i,j);

				   System.out.println(dataArray[ci][cj]);  

					}

				}
		return dataArray;
		
	}

	public void openExcelWorkbook(String sFileName) {
		try {
			oFileReader = new FileInputStream(sFileName);			
			oExcelWorkbook = WorkbookFactory.create(oFileReader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCountOfSheet(String sSheetName) {
		try {
			Sheet oSheet;
			oSheet = oExcelWorkbook.getSheet(sSheetName);
			System.out.println("Sheet Name: " + sSheetName);
			return oSheet.getPhysicalNumberOfRows();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// ------------------------------------------------------------------------

	public int getCellCount(String sSheetName, int iRow) {
		try {
			Sheet oSheet;

			oSheet = oExcelWorkbook.getSheet(sSheetName);
			Row oRow;
			oRow = oSheet.getRow(iRow - 1);
			return oRow.getLastCellNum();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// ---------------------------------------------------------------------

	public String getCellData(String sSheetName, int iRow, int iCell) {
		try {
			Sheet oSheet;
			oSheet = oExcelWorkbook.getSheet(sSheetName);
			Row oRow;

			oRow = oSheet.getRow(iRow - 1);
			Cell oCell;
			oCell = oRow.getCell(iCell - 1);
			if (oCell == null) {
				return "";
			} else {

				if (oCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					System.out
							.println("Cell Value:"
									+ String.valueOf((long) oCell
											.getNumericCellValue()));
					return String.valueOf((long) oCell.getNumericCellValue());
				} else {
					System.out.println("String cell value: "
							+ oCell.getStringCellValue());
					return oCell.getStringCellValue();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

}
