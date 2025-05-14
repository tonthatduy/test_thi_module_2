package thi_thu_module_2.quan_ly.repository;

import thi_thu_module_2.quan_ly.common.ReadAndWriteFile;
import thi_thu_module_2.quan_ly.entity.Drone;
import thi_thu_module_2.quan_ly.entity.XeTuanTra;

import java.util.ArrayList;
import java.util.List;

public class XeTuanTraRepository implements IXeTuanTraRepository {
    private static final String XETUANTRA_PATH = "src/thi_thu_module_2/quan_ly/data/xeTuanTra.csv";

    @Override
    public void add(XeTuanTra xeTuanTra) {
        List<String> stringList = new ArrayList<>();
        stringList.add(xeTuanTra.getFileCSVXeTuanTra());
        ReadAndWriteFile.writeFileCSV(XETUANTRA_PATH, stringList, true);

    }

    @Override
    public List<XeTuanTra> findAll() {
        List<XeTuanTra> xeTuanTras = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFileCSV(XETUANTRA_PATH);
        String[] array;
        for (int i = 0; i < stringList.size(); i++) {
            array = stringList.get(i).split("\\s*,\\s*");
            XeTuanTra xeTuanTra = new XeTuanTra(array[0], array[1], Integer.parseInt(array[2]), array[3], Integer.parseInt(array[4]));
            xeTuanTras.add(xeTuanTra);
        }

        return xeTuanTras;
    }

    @Override
    public void delete(XeTuanTra xeTuanTra) {
        List<XeTuanTra> xeTuanTras = findAll();
        xeTuanTras.remove(xeTuanTra);
        List<String> stringList = new ArrayList<>();
        for (XeTuanTra xeTuanTra1 : xeTuanTras) {
            stringList.add(xeTuanTra1.getFileCSVXeTuanTra());
        }
        ReadAndWriteFile.writeFileCSV(XETUANTRA_PATH, stringList, false);

    }
}
