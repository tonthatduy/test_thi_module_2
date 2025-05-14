package thi_thu_module_2.quan_ly.repository;

import thi_thu_module_2.quan_ly.common.ReadAndWriteFile;
import thi_thu_module_2.quan_ly.entity.HangCheTao;

import java.util.ArrayList;
import java.util.List;

public class HangCheTaoRepository implements IHangCheTaoRepository {
    private static String HANGCHETAO_PATH = "src/thi_thu_module_2/quan_ly/data/hangCheTao.csv";

    @Override
    public List<HangCheTao> findAll() {
        List<String> stringList = ReadAndWriteFile.readFileCSV(HANGCHETAO_PATH);
        List<HangCheTao> hangCheTaos = new ArrayList<>();
        for (String s : stringList) {
            String[] array = s.split("\\s*,\\s*");
            hangCheTaos.add(new HangCheTao(array[0], array[1], array[2]));
        }

        return hangCheTaos;
    }

    @Override
    public HangCheTao findByID(String type) {
        for (HangCheTao hangCheTao : findAll()) {
            if (hangCheTao.getMaHang().equalsIgnoreCase(type)) {
                return hangCheTao;
            }
        }
        return null;
    }
}
