package com.zhiye.common.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jxl.CellType;
import jxl.format.Border;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.zhiye.common.bean.ZyIndex;
import com.zhiye.common.bean.ZyIndexProd;

public class ReportUtil {

	static WritableWorkbook wwb;

	public static void init(String excel, int count) {
		try {
			jxl.Workbook workbook = null;
			if (count == -1) {
				workbook = jxl.Workbook.getWorkbook(new File(Config
						.getString("sample_product_path")));
			} else {
				workbook = jxl.Workbook.getWorkbook(new File(Config
						.getString("sample" + count + "_path")));
			}
			wwb = jxl.Workbook.createWorkbook(new File(excel), workbook);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Long[] statisticsProducts(List<ZyIndexProd> indexProds) {
		if (indexProds == null || indexProds.size() == 0) {
			return null;
		}
		Long[] v1 = new Long[2];
		for (int i = 0; i < 2; i++) {
			v1[i] = 0l;
		}
		for (ZyIndexProd index : indexProds) {
			if (index.getV01() != null && index.getV01().longValue() >= 0) {
				v1[0] += index.getV01().longValue();
			}
			if (index.getS01() != null && index.getS01().longValue() >= 0) {
				v1[1] += index.getS01().longValue();
			}

		}
		return v1;
	}

	/**
	 * 根据报表列表计算出每个指标的总和
	 * 
	 * @param indexs
	 * @return
	 */
	public static Long[] statistics(List<ZyIndex> indexs) {
		if (indexs == null || indexs.size() == 0) {
			return null;
		}
		Long[] v1 = new Long[72];
		// 初始化
		for (int i = 0; i < 72; i++) {
			v1[i] = 0l;
		}
		for (ZyIndex index : indexs) {
			// 工业总产值
			if (index.getGyzczv1() != null && index.getGyzczv1() >= 0) {
				v1[0] += index.getGyzczv1();
			}
			if (index.getGyzczv2() != null && index.getGyzczv2() >= 0) {
				v1[1] += index.getGyzczv2();
			}
			if (index.getGyzczv3() != null && index.getGyzczv3() >= 0) {
				v1[2] += index.getGyzczv3();
			}
			// 工业增加值
			if (index.getGyzjzv1() != null && index.getGyzjzv1() >= 0) {
				v1[3] += index.getGyzjzv1();
			}
			if (index.getGyzjzv2() != null && index.getGyzjzv2() >= 0) {
				v1[4] += index.getGyzjzv2();
			}
			if (index.getGyzjzv3() != null && index.getGyzjzv3() >= 0) {
				v1[5] += index.getGyzjzv3();
			}
			// 新产品产值
			if (index.getXcpczv1() != null && index.getXcpczv1() >= 0) {
				v1[6] += index.getXcpczv1();
			}
			if (index.getXcpczv2() != null && index.getXcpczv2() >= 0) {
				v1[7] += index.getXcpczv2();
			}
			if (index.getXcpczv3() != null && index.getXcpczv3() >= 0) {
				v1[8] += index.getXcpczv3();
			}
			// 工业销售产值
			if (index.getGyxsczv1() != null && index.getGyxsczv1() >= 0) {
				v1[9] += index.getGyxsczv1();
			}
			if (index.getGyxsczv2() != null && index.getGyxsczv2() >= 0) {
				v1[10] += index.getGyxsczv2();
			}
			if (index.getGyxsczv3() != null && index.getGyxsczv3() >= 0) {
				v1[11] += index.getGyxsczv3();
			}
			// 出口交货值
			if (index.getCkjhzv1() != null && index.getCkjhzv1() >= 0) {
				v1[12] += index.getCkjhzv1();
			}
			if (index.getCkjhzv2() != null && index.getCkjhzv2() >= 0) {
				v1[13] += index.getCkjhzv2();
			}
			if (index.getCkjhzv3() != null && index.getCkjhzv3() >= 0) {
				v1[14] += index.getCkjhzv3();
			}
			// 产品销售收入
			if (index.getCpxssrv1() != null && index.getCpxssrv1() >= 0) {
				v1[15] += index.getCpxssrv1();
			}
			if (index.getCpxssrv2() != null && index.getCpxssrv2() >= 0) {
				v1[16] += index.getCpxssrv2();
			}
			if (index.getCpxssrv3() != null && index.getCpxssrv3() >= 0) {
				v1[17] += index.getCpxssrv3();
			}
			// 产品销售成本
			if (index.getCpxscbv1() != null && index.getCpxscbv1() >= 0) {
				v1[18] += index.getCpxscbv1();
			}
			if (index.getCpxscbv2() != null && index.getCpxscbv2() >= 0) {
				v1[19] += index.getCpxscbv2();
			}
			if (index.getCpxscbv3() != null && index.getCpxscbv3() >= 0) {
				v1[20] += index.getCpxscbv3();
			}
			// 产品销售费用
			if (index.getCpxsfyv1() != null && index.getCpxsfyv1() >= 0) {
				v1[21] += index.getCpxsfyv1();
			}
			if (index.getCpxsfyv2() != null && index.getCpxsfyv2() >= 0) {
				v1[22] += index.getCpxsfyv2();
			}
			if (index.getCpxsfyv3() != null && index.getCpxsfyv3() >= 0) {
				v1[23] += index.getCpxsfyv3();
			}
			// 产品销售税金及附加
			if (index.getCpxssjjfjv1() != null && index.getCpxssjjfjv1() >= 0) {
				v1[24] += index.getCpxssjjfjv1();
			}
			if (index.getCpxssjjfjv2() != null && index.getCpxssjjfjv2() >= 0) {
				v1[25] += index.getCpxssjjfjv2();
			}
			if (index.getCpxssjjfjv3() != null && index.getCpxssjjfjv3() >= 0) {
				v1[26] += index.getCpxssjjfjv3();
			}
			// 管理费用
			if (index.getGlfyv1() != null && index.getGlfyv1() >= 0) {
				v1[27] += index.getGlfyv1();
			}
			if (index.getGlfyv2() != null && index.getGlfyv2() >= 0) {
				v1[28] += index.getGlfyv2();
			}
			if (index.getGlfyv3() != null && index.getGlfyv3() >= 0) {
				v1[29] += index.getGlfyv3();
			}
			// 财务费用
			if (index.getCwfyv1() != null && index.getCwfyv1() >= 0) {
				v1[30] += index.getCwfyv1();
			}
			if (index.getCwfyv2() != null && index.getCwfyv2() >= 0) {
				v1[31] += index.getCwfyv2();
			}
			if (index.getCwfyv3() != null && index.getCwfyv3() >= 0) {
				v1[32] += index.getCwfyv3();
			}
			// 利息支出
			if (index.getLxzcv1() != null && index.getLxzcv1() >= 0) {
				v1[33] += index.getLxzcv1();
			}
			if (index.getLxzcv2() != null && index.getLxzcv2() >= 0) {
				v1[34] += index.getLxzcv2();
			}
			if (index.getLxzcv3() != null && index.getLxzcv3() >= 0) {
				v1[35] += index.getLxzcv3();
			}
			// 利润总额
			if (index.getLrzev1() != null && index.getLrzev1() >= 0) {
				v1[36] += index.getLrzev1();
			}
			if (index.getLrzev2() != null && index.getLrzev2() >= 0) {
				v1[37] += index.getLrzev2();
			}
			if (index.getLrzev3() != null && index.getLrzev3() >= 0) {
				v1[38] += index.getLrzev3();
			}
			// 利税总额
			if (index.getLszev1() != null && index.getLszev1() >= 0) {
				v1[39] += index.getLszev1();
			}
			if (index.getLszev2() != null && index.getLszev2() >= 0) {
				v1[40] += index.getLszev2();
			}
			if (index.getLszev3() != null && index.getLszev3() >= 0) {
				v1[41] += index.getLszev3();
			}
			// 应交增值税
			if (index.getYjzzsv1() != null && index.getYjzzsv1() >= 0) {
				v1[42] += index.getYjzzsv1();
			}
			if (index.getYjzzsv2() != null && index.getYjzzsv2() >= 0) {
				v1[43] += index.getYjzzsv2();
			}
			if (index.getYjzzsv3() != null && index.getYjzzsv3() >= 0) {
				v1[44] += index.getYjzzsv3();
			}
			// 全部流动资产
			if (index.getQbldzcv1() != null && index.getQbldzcv1() >= 0) {
				v1[45] += index.getQbldzcv1();
			}
			if (index.getQbldzcv2() != null && index.getQbldzcv2() >= 0) {
				v1[46] += index.getQbldzcv2();
			}
			if (index.getQbldzcv3() != null && index.getQbldzcv3() >= 0) {
				v1[47] += index.getQbldzcv3();
			}
			// 固定资产净值
			if (index.getGdzcjzv1() != null && index.getGdzcjzv1() >= 0) {
				v1[48] += index.getGdzcjzv1();
			}
			if (index.getGdzcjzv2() != null && index.getGdzcjzv2() >= 0) {
				v1[49] += index.getGdzcjzv2();
			}
			if (index.getGdzcjzv3() != null && index.getGdzcjzv3() >= 0) {
				v1[50] += index.getGdzcjzv3();
			}
			// 产成品存货
			if (index.getCcpchv1() != null && index.getCcpchv1() >= 0) {
				v1[51] += index.getCcpchv1();
			}
			if (index.getCcpchv2() != null && index.getCcpchv2() >= 0) {
				v1[52] += index.getCcpchv2();
			}
			if (index.getCcpchv3() != null && index.getCcpchv3() >= 0) {
				v1[53] += index.getCcpchv3();
			}
			// 应收帐款净额
			if (index.getYszkjev1() != null && index.getYszkjev1() >= 0) {
				v1[54] += index.getYszkjev1();
			}
			if (index.getYszkjev2() != null && index.getYszkjev2() >= 0) {
				v1[55] += index.getYszkjev2();
			}
			if (index.getYszkjev3() != null && index.getYszkjev3() >= 0) {
				v1[56] += index.getYszkjev3();
			}
			// 资产合计
			if (index.getZchjv1() != null && index.getZchjv1() >= 0) {
				v1[57] += index.getZchjv1();
			}
			if (index.getZchjv2() != null && index.getZchjv2() >= 0) {
				v1[58] += index.getZchjv2();
			}
			if (index.getZchjv3() != null && index.getZchjv3() >= 0) {
				v1[59] += index.getZchjv3();
			}
			// 负债合计
			if (index.getFzhjv1() != null && index.getFzhjv1() >= 0) {
				v1[60] += index.getFzhjv1();
			}
			if (index.getFzhjv2() != null && index.getFzhjv2() >= 0) {
				v1[61] += index.getFzhjv2();
			}
			if (index.getFzhjv3() != null && index.getFzhjv3() >= 0) {
				v1[62] += index.getFzhjv3();
			}
			// 当年固定资产投资累计
			if (index.getDngdzctzljv1() != null && index.getDngdzctzljv1() >= 0) {
				v1[63] += index.getDngdzctzljv1();
			}
			if (index.getDngdzctzljv2() != null && index.getDngdzctzljv2() >= 0) {
				v1[64] += index.getDngdzctzljv2();
			}
			if (index.getDngdzctzljv3() != null && index.getDngdzctzljv3() >= 0) {
				v1[65] += index.getDngdzctzljv3();
			}
			// 设备投资
			if (index.getSbtzv1() != null && index.getSbtzv1() >= 0) {
				v1[66] += index.getSbtzv1();
			}
			if (index.getSbtzv2() != null && index.getSbtzv2() >= 0) {
				v1[67] += index.getSbtzv2();
			}
			if (index.getSbtzv3() != null && index.getSbtzv3() >= 0) {
				v1[68] += index.getSbtzv3();
			}
			// 全部从业人员人数
			if (index.getQbcyryrsv1() != null && index.getQbcyryrsv1() >= 0) {
				v1[69] += index.getQbcyryrsv1();
			}
			if (index.getQbcyryrsv2() != null && index.getQbcyryrsv2() >= 0) {
				v1[70] += index.getQbcyryrsv2();
			}
			if (index.getQbcyryrsv3() != null && index.getQbcyryrsv3() >= 0) {
				v1[71] += index.getQbcyryrsv3();
			}
		}
		return v1;

	}

	/**
	 * 为EXCEL 1的行准备数据
	 * 
	 */
	public static Object[] prepareRowData1(Long[] data) {
		if (data == null || data.length == 0) {
			return null;
		}
		Object[] newData = new Object[19];
		DecimalFormat digits = new DecimalFormat("0.0");
		// 工业总产值
		newData[0] = data[0];
		newData[1] = data[1];
		if (data[1] == 0) {
			newData[2] = 0;
		} else {
			newData[2] = digits.format(100 * (data[0] - data[1])
					/ (double) data[1]);
		}

		// 新产品产值
		newData[3] = data[6];
		newData[4] = data[7];
		if (data[7] == 0) {
			newData[5] = 0;
		} else {
			newData[5] = digits.format(100 * (data[6] - data[7])
					/ (double) data[7]);
		}
		// 工业销售产值
		newData[6] = data[9];
		newData[7] = data[10];
		if (data[10] == 0) {
			newData[8] = 0;
		} else {
			newData[8] = digits.format(100 * (data[9] - data[10])
					/ (double) data[10]);
		}
		// 出口交货值
		newData[9] = data[12];
		newData[10] = data[13];
		if (data[13] == 0) {
			newData[11] = 0;
		} else {
			newData[11] = digits.format(100 * (data[12] - data[13])
					/ (double) data[13]);
		}

		// 产品销售收入
		newData[12] = data[15];
		newData[13] = data[16];
		if (data[16] == 0) {
			newData[14] = 0;
		} else {
			newData[14] = digits.format(100 * (data[15] - data[16])
					/ (double) data[16]);
		}

		// 产销率
		if (data[9] == 0) {
			newData[15] = 0;
		} else {
			newData[15] = digits.format(data[0] / (double) data[9]);
		}

		// 产品销售成本
		newData[16] = data[18];
		newData[17] = data[19];
		if (data[19] == 0) {
			newData[18] = 0;
		} else {
			newData[18] = digits.format(100 * (data[18] - data[19])
					/ (double) data[19]);
		}

		return newData;
	}

	/**
	 * 为EXCEL 2的行准备数据
	 * 
	 */
	public static Object[] prepareRowData2(Long[] data) {
		if (data == null || data.length == 0) {
			return null;
		}
		Object[] newData = new Object[24];
		DecimalFormat digits = new DecimalFormat("0.0");
		// 产品销售费用
		newData[0] = data[21];
		newData[1] = data[22];
		if (data[22] == 0) {
			newData[2] = 0;
		} else {
			newData[2] = digits.format(100 * (data[21] - data[22])
					/ (double) data[22]);
		}

		// 产品销售税金及附加
		newData[3] = data[24];
		newData[4] = data[25];
		if (data[25] == 0) {
			newData[5] = 0;
		} else {
			newData[5] = digits.format(100 * (data[24] - data[25])
					/ (double) data[25]);
		}
		// 管理费用
		newData[6] = data[27];
		newData[7] = data[28];
		if (data[28] == 0) {
			newData[8] = 0;
		} else {
			newData[8] = digits.format(100 * (data[27] - data[28])
					/ (double) data[28]);
		}
		// 财务费用
		newData[9] = data[30];
		newData[10] = data[31];
		if (data[31] == 0) {
			newData[11] = 0;
		} else {
			newData[11] = digits.format(100 * (data[30] - data[31])
					/ (double) data[31]);
		}

		// 利息支出
		newData[12] = data[33];
		newData[13] = data[34];
		if (data[34] == 0) {
			newData[14] = 0;
		} else {
			newData[14] = digits.format(100 * (data[33] - data[34])
					/ (double) data[34]);
		}
		// 利润总额
		newData[15] = data[36];
		newData[16] = data[37];
		if (data[37] == 0) {
			newData[17] = 0;
		} else {
			newData[17] = digits.format(100 * (data[36] - data[37])
					/ (double) data[37]);
		}

		// 利税总额
		newData[18] = data[39];
		newData[19] = data[40];
		if (data[40] == 0) {
			newData[20] = 0;
		} else {
			newData[20] = digits.format(100 * (data[39] - data[40])
					/ (double) data[40]);
		}

		// 应交增值税
		newData[21] = data[42];
		newData[22] = data[43];
		if (data[43] == 0) {
			newData[23] = 0;
		} else {
			newData[23] = digits.format(100 * (data[42] - data[43])
					/ (double) data[43]);
		}

		return newData;
	}

	/**
	 * 为EXCEL 3的行准备数据
	 * 
	 */
	public static Object[] prepareRowData3(Long[] data) {
		if (data == null && data.length == 0) {
			return null;
		}
		Object[] newData = new Object[22];
		DecimalFormat digits = new DecimalFormat("0.0");

		// 全部流动资产
		newData[0] = data[45];
		newData[1] = data[46];
		if (data[46] == 0) {
			newData[2] = 0;
		} else {
			newData[2] = digits.format(100 * (data[45] - data[46])
					/ (double) data[46]);
		}

		// 固定资产净值
		newData[3] = data[48];
		newData[4] = data[49];
		if (data[49] == 0) {
			newData[5] = 0;
		} else {
			newData[5] = digits.format(100 * (data[48] - data[49])
					/ (double) data[49]);
		}
		// 产成品存货
		newData[6] = data[51];
		newData[7] = data[52];
		if (data[52] == 0) {
			newData[8] = 0;
		} else {
			newData[8] = digits.format(100 * (data[51] - data[52])
					/ (double) data[52]);
		}

		// 应收账款净额
		newData[9] = data[54];
		newData[10] = data[55];
		if (data[55] == 0) {
			newData[11] = 0;
		} else {
			newData[11] = digits.format(100 * (data[54] - data[55])
					/ (double) data[55]);
		}
		// 资产合计
		newData[12] = data[57];
		// 负债合计
		newData[13] = data[60];
		// 资产负债率
		if (data[57] == 0) {
			newData[14] = 0;
		} else {
			newData[14] = digits.format(data[60] / (double) data[57]);
		}

		// 当年固定资产投资累计
		newData[15] = data[63];
		newData[16] = data[64];
		if (data[64] == 0) {
			newData[17] = 0;
		} else {
			newData[17] = digits.format(100 * (data[63] - data[64])
					/ (double) data[64]);
		}

		// 设备投资
		newData[18] = data[66];
		newData[19] = data[67];
		if (data[67] == 0) {
			newData[20] = 0;
		} else {
			newData[20] = digits.format(100 * (data[66] - data[67])
					/ (double) data[67]);
		}

		// 职工人数
		newData[21] = data[69];
		return newData;
	}

	/**
	 * 为EXCEL 4的行准备数据
	 * 
	 */
	public static Object[] prepareRowData4(Long[] data) {
		if (data == null ||data.length == 0) {
			return null;
		}
		Object[] newData = new Object[3];
		DecimalFormat digits = new DecimalFormat("0.0");
		// 累计产值
		newData[0] = data[0];
		// 上年同期产值
		newData[1] = data[1];
		if (data[1] == 0) {
			newData[2] = 0;
		} else {
			newData[2] = digits.format(100 * (data[0] - data[1])
					/ (double) data[1]);
		}

		return newData;
	}

	/**
	 * 准备EXCEL 的数据
	 * 
	 * @param allCompanies
	 * @param areas
	 * @param trades
	 * @param companys
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	public static void prepareExcel(Object[] allCompanies,
			Map<String, Object[]> areas, Map<String, Object[]> trades,
			Map<String, Object[]> companys, String fileName, int year,
			int month, int count) throws RowsExceededException, WriteException {
		// File target=new File("D://ddd/");
		// try {
		// target.mkdir();
		// } catch (Exception e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		
		if(allCompanies==null){
			return;
		}
		init(fileName, count);

		int totalRow = 0;
		WritableSheet sheet2 = wwb.getSheet(0);

		// 修改EXCEL的表头
		WritableCell cell = sheet2.getWritableCell(0, 0);
		WritableCell cell1 = sheet2.getWritableCell(0, 45);
		if (cell.getType() == CellType.LABEL) {
			Label l = (Label) cell;
			String biaotou = l.getString();
			biaotou = biaotou.replace("param1", "" + year);
			biaotou = biaotou.replace("param2", "" + month);
			biaotou = biaotou.replace("param3", "" + count);
			l.setString(biaotou);
		}

		if (cell1.getType() == CellType.LABEL) {
			Label l = (Label) cell1;
			String biaotou = l.getString();
			biaotou = biaotou.replace("param1", "" + year);
			biaotou = biaotou.replace("param2", "" + month);
			biaotou = biaotou.replace("param3", "" + count);
			l.setString(biaotou);
		}
		WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 10,
				WritableFont.NO_BOLD);
		WritableCellFormat cellFormat1 = new WritableCellFormat(font);
		cellFormat1.setBorder(Border.ALL, jxl.format.BorderLineStyle.THIN);
		// allCompanies = new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114,
		// 555,
		// 66.5, 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 };

		// 准备总计的数据
		int left = 4;
		int top = 1;
		for (Object obj : allCompanies) {
			if (top == 3 || top == 6 || top == 9 || top == 12 || top == 15
					|| top == 16 || top == 19) {

				Label label = new Label(top, left, obj.toString() + "%");
				label.setCellFormat(cellFormat1);
				sheet2.addCell(label);
			} else {
				Number num = new Number(top, left, Float.parseFloat(obj
						.toString()));
				num.setCellFormat(cellFormat1);
				sheet2.addCell(num);
			}
			top++;
		}

		// 准备地区的数据
		// 添加分地区
		Label l1 = new Label(0, 5, "分地区");
		totalRow = 5;
		WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"),
				10, WritableFont.BOLD);
		WritableCellFormat cellFormat2 = new WritableCellFormat(font1);
		l1.setCellFormat(cellFormat2);
		sheet2.addCell(l1);
		// Map<String, Object[]> map1 = new HashMap<String, Object[]>();
		// map1.put("撒旦发射",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		// map1.put("士大夫士大夫",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		//
		// map1.put("士大夫是",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		Iterator iter = areas.entrySet().iterator();
		left = 6;
		while (iter.hasNext()) {
			// 行数 递增
			totalRow++;
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object[] val = (Object[]) entry.getValue();
			// 添加地区名称
			top = 0;
			Label label1 = new Label(top, left, key.toString());
			label1.setCellFormat(cellFormat1);
			sheet2.addCell(label1);
			top = 1;
			for (Object obj : val) {

				if (top == 3 || top == 6 || top == 9 || top == 12 || top == 15
						|| top == 16 || top == 19) {
					Label label = new Label(top, left, obj.toString() + "%");
					label.setCellFormat(cellFormat1);
					sheet2.addCell(label);
				} else {
					Number num = new Number(top, left, Float.parseFloat(obj
							.toString()));
					num.setCellFormat(cellFormat1);
					sheet2.addCell(num);
				}
				top++;
			}
			left++;
		}

		// 添加行业
		totalRow++;
		Label l2 = new Label(0, totalRow, "fenghangye");
		l2.setCellFormat(cellFormat2);
		sheet2.addCell(l2);
		// Map<String, Object[]> map2 = new HashMap<String, Object[]>();
		// map2.put("萨顶顶",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		// map2.put("速度是",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		//
		// map2.put("放到啊啊",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		Iterator iter1 = trades.entrySet().iterator();
		left = totalRow + 1;
		totalRow++;
		while (iter1.hasNext()) {
			Map.Entry entry = (Map.Entry) iter1.next();
			Object key = entry.getKey();
			Object[] val = (Object[]) entry.getValue();
			// 添加行业名称
			top = 0;
			Label label1 = new Label(top, left, key.toString());
			label1.setCellFormat(cellFormat1);
			sheet2.addCell(label1);
			top = 1;
			for (Object obj : val) {

				if (top == 3 || top == 6 || top == 9 || top == 12 || top == 15
						|| top == 16 || top == 19) {
					Label label = new Label(top, left, obj.toString() + "%");
					label.setCellFormat(cellFormat1);
					sheet2.addCell(label);
				} else {
					Number num = new Number(top, left, Float.parseFloat(obj
							.toString()));
					num.setCellFormat(cellFormat1);
					sheet2.addCell(num);
				}
				top++;
			}
			left++;
			totalRow++;
		}

		// 添加企业
		Label l3 = new Label(0, totalRow, "分企业");
		l3.setCellFormat(cellFormat2);
		sheet2.addCell(l3);
		// Map<String, Object[]> map3 = new HashMap<String, Object[]>();
		// map3.put("安安商店速度撒",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		// map3.put("阿萨德发生大幅阿萨德", new Object[] { 111, 111, 92.2, 111, 222, 33.3,
		// 114, 555, 66.5, 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555,
		// 44.2 });
		//
		// map3.put("放到的方式告诉对方时", new Object[] { 111, 111, 92.2, 111, 222, 33.3,
		// 114, 555, 66.5, 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555,
		// 44.2 });
		// map3.put("阿斯蒂芬",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		// map3.put("地方更好的",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		// map3.put("而威尔威尔",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		// map3.put("正徐徐现在v",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		// map3.put("时代风格",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		// map3.put("过后就会感觉",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		// map3.put("颗粒颗粒剂速度",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		// map3.put("沃尔沃斯蒂芬撒",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });
		// map3.put("初步形成表现才",
		// new Object[] { 111, 111, 92.2, 111, 222, 33.3, 114, 555, 66.5,
		// 444, 555, 66.8, 44, 888, 45.5, 55.5, 444, 555, 44.2 });

		Iterator iter2 = companys.entrySet().iterator();
		left = totalRow + 1;
		totalRow++;
		while (iter2.hasNext()) {
			if (totalRow == 45) {
				totalRow = 48;
				left = left + 4;
			}
			Map.Entry entry = (Map.Entry) iter2.next();
			Object key = entry.getKey();
			Object[] val = (Object[]) entry.getValue();
			// 添加行业名称
			top = 0;
			Label label1 = new Label(top, left, key.toString());
			label1.setCellFormat(cellFormat1);
			sheet2.addCell(label1);
			top = 1;
			for (Object obj : val) {

				if (top == 3 || top == 6 || top == 9 || top == 12 || top == 15
						|| top == 16 || top == 19) {
					Label label = new Label(top, left, obj.toString() + "%");
					label.setCellFormat(cellFormat1);
					sheet2.addCell(label);
				} else {
					Number num = new Number(top, left, Float.parseFloat(obj
							.toString()));
					num.setCellFormat(cellFormat1);
					sheet2.addCell(num);
				}
				top++;
			}
			left++;
			totalRow++;
		}

		// 制作表头
		// jxl.write.WritableFont titleFont = new jxl.write.WritableFont(
		// WritableFont.createFont("宋体"), 18, WritableFont.BOLD);
		// jxl.write.WritableCellFormat titleFormat = new
		// jxl.write.WritableCellFormat(
		// titleFont);
		// titleFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
		// titleFormat.setAlignment(Alignment.CENTRE); // 水平对齐
		// titleFormat.setWrap(true); // 是否换行
		//		
		// //TOP,LEFT,LENGTH,HEIGHT
		// sheet2.mergeCells(0, 0, 19, 0);
		// jxl.write.Label tit = new jxl.write.Label(0, 0,
		// "马鞍山市2012年1-3月重点企业主要经济指标统计快报 (表1)", titleFormat);
		// sheet2.addCell(tit);
		// jxl.write.Label tit1 = new jxl.write.Label(0, 1, "制表:市经信委经济运行科");
		// sheet2.addCell(tit1);
		//		
		try {
			wwb.write();
			wwb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 准备EXCEL 的数据
	 * 
	 * @param allCompanies
	 * @param areas
	 * @param trades
	 * @param companys
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	public static void prepareExcel4(Map<String, Object[]> products,
			Map<String, Map<String,Object[]>> allCorps, List<String> units,
			String fileName, int year, int month, int count)
			throws RowsExceededException, WriteException {
		init(fileName, count);
		int totalRow = 0;
		WritableSheet sheet2 = wwb.getSheet(0);

		// 修改EXCEL的表头
		WritableCell cell = sheet2.getWritableCell(0, 0);
		WritableCell cell1 = sheet2.getWritableCell(0, 46);
		if (cell.getType() == CellType.LABEL) {
			Label l = (Label) cell;
			String biaotou = l.getString();
			biaotou = biaotou.replace("param1", "" + year);
			biaotou = biaotou.replace("param2", "" + month);
			l.setString(biaotou);
		}

		if (cell1.getType() == CellType.LABEL) {
			Label l = (Label) cell1;
			String biaotou = l.getString();
			biaotou = biaotou.replace("param1", "" + year);
			biaotou = biaotou.replace("param2", "" + month);
			l.setString(biaotou);
		}
		WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 10,
				WritableFont.NO_BOLD);
		WritableCellFormat cellFormat1 = new WritableCellFormat(font);
		cellFormat1.setBorder(Border.ALL, jxl.format.BorderLineStyle.THIN);

		// 准备产品的数据
		Iterator iter = products.entrySet().iterator();
		int left = 4;
		int top = 0;
		int r = 0;
		while (iter.hasNext()) {
			// 行数 递增
			totalRow++;
			if (totalRow == 42) {
				totalRow = 46;
				left = left + 4;
			}
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object[] val = (Object[]) entry.getValue();
			if(val==null){
				continue;
			}
			top = 0;
			Label label1 = new Label(top, left, key.toString());
			label1.setCellFormat(cellFormat1);
			sheet2.addCell(label1);
			top = 1;
			Label label2 = new Label(top, left, units.get(r));
			label2.setCellFormat(cellFormat1);
			sheet2.addCell(label2);
			top = 2;
			for (Object obj : val) {
				if (top == 4) {
					Label label = new Label(top, left, obj.toString() + "%");
					label.setCellFormat(cellFormat1);
					sheet2.addCell(label);
				} else {
					Number num = new Number(top, left, Float.parseFloat(obj
							.toString()));
					num.setCellFormat(cellFormat1);
					sheet2.addCell(num);
				}
				top++;
			}
		
			Map<String,Object[]> coprs = allCorps.get(key);
			Iterator iter3 = coprs.entrySet().iterator();
			while(iter3.hasNext()){
				Map.Entry entry3 = (Map.Entry) iter3.next();
				Object key1 = entry3.getKey();
				Object[] obj = (Object[]) entry3.getValue();
				if(obj==null){
					continue;
				}
				left++;
				totalRow++;
				if (totalRow == 42) {
					totalRow = 46;
					left = left + 4;
				}
				top = 0;
				Label label3 = new Label(top, left, key1.toString());
				label3.setCellFormat(cellFormat1);
				sheet2.addCell(label3);
				top = 1;
				Label label4 = new Label(top, left, "");
				label4.setCellFormat(cellFormat1);
				sheet2.addCell(label4);
				top = 2;
				for (Object obj1 : obj) {
					if (top == 4) {
						Label label = new Label(top, left, obj1.toString()
								+ "%");
						label.setCellFormat(cellFormat1);
						sheet2.addCell(label);
					} else {
						Number num = new Number(top, left, Float
								.parseFloat(obj1.toString()));
						num.setCellFormat(cellFormat1);
						sheet2.addCell(num);
					}
					top++;
				}
			}
			left++;
			r++;
		}
		try {
			wwb.write();
			wwb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Object[] newData = new Object[2];
		DecimalFormat digits = new DecimalFormat("0.0");
		// 工业总产值
		newData[1] = digits.format(100 * (7 - 11) / (double) 11);
		System.out.println(newData[1]);
	}

}
