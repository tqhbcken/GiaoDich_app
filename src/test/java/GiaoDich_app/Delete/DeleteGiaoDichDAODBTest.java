package GiaoDich_app.Delete;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


import GiaoDich_app.database.DeleteGiaoDichDAODB;

public class DeleteGiaoDichDAODBTest {
    private DeleteGiaoDichDAODB dao;

    @Before
    public void setUp() {
        dao = new DeleteGiaoDichDAODB();
        // Thiết lập dữ liệu test
    }

    @Test
    public void testXoaGiaoDichThanhCong() {
        String maGiaoDich = "GD001"; // Mã giao dịch tồn tại trong DB
        assertTrue("Xóa giao dịch thành công", dao.deleteGiaoDich(maGiaoDich));
    }

    @Test 
    public void testXoaGiaoDichThatBai() {
        String maGiaoDich = "GD999"; // Mã giao dịch không tồn tại
        assertFalse("Xóa giao dịch thất bại do không tìm thấy", dao.deleteGiaoDich(maGiaoDich));
    }
}
