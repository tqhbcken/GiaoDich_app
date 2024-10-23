package GiaoDich_app;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import GiaoDich_app.database.AddGiaoDichDAODB;
import GiaoDich_app.entity.GiaoDich;
import GiaoDich_app.entity.GiaoDichDat;

public class AddGiaoDichTest {
    private AddGiaoDichDAODB dao;
    
    @Before
    public void setUp() {
        dao = new AddGiaoDichDAODB();
    }

    @Test
    public void testAddGiaoDich() {
        // Tạo một đối tượng GiaoDich để thêm
        GiaoDichDat giaoDichDat = new GiaoDichDat(100, 2000000, new Date(), "N");

        // Thêm giao dịch vào cơ sở dữ liệu
        int id = dao.addGiaoDich(giaoDichDat);

        // Kiểm tra ID được trả về không null và lớn hơn 0
        assertNotNull(id);
        assertEquals(1, id); // Kiểm tra ID đầu tiên là 1

        // Kiểm tra giao dịch đã được thêm thành công
        GiaoDich retrievedGiaoDich = dao.findGiaoDichById(id);
        assertNotNull(retrievedGiaoDich);
        
        // So sánh diện tích và đơn giá với delta
        
        assertEquals(100.0, retrievedGiaoDich.getDienTich(), 0.001);
        assertEquals(2000000.0, retrievedGiaoDich.getDonGia(), 0.001);
        assertEquals("Dat", retrievedGiaoDich.getLoaiGD());
    }

    // @Test
    // public void testAddGiaoDichNha() {
    //     // Tạo một đối tượng GiaoDichNha để thêm
    //     GiaoDichNha giaoDichNha = new GiaoDichNha("456 Đường XYZ", "Vip", 150, 3000000, new Date());

    //     // Thêm giao dịch vào cơ sở dữ liệu
    //     int id = dao.addGiaoDich(giaoDichNha);

    //     // Kiểm tra ID được trả về không null và lớn hơn 0
    //     assertNotNull(id);
    //     assertEquals(1, id); // Kiểm tra ID đầu tiên là 1

    //     // Kiểm tra giao dịch đã được thêm thành công
    //     GiaoDichNha retrievedGiaoDich = (GiaoDichNha) dao.findGiaoDichById(id);
    //     assertNotNull(retrievedGiaoDich);
        
    //     // So sánh diện tích, đơn giá và loại nhà với delta
    //     assertEquals(150.0, retrievedGiaoDich.getDienTich(), 0.001);
    //     assertEquals(3000000.0, retrievedGiaoDich.getDonGia(), 0.001);
    //     assertEquals("Nha", retrievedGiaoDich.getLoaiGD());
    //     assertEquals("Vip", retrievedGiaoDich.getLoaiNha());
    //     assertEquals("456 Đường XYZ", retrievedGiaoDich.getDiaChi());
    // }
}
