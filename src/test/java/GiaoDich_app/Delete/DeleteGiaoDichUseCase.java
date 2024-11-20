package GiaoDich_app.Delete;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import GiaoDich_app.database.DeleteGiaoDichDAODB;

public class DeleteGiaoDichUseCase {
    private DeleteGiaoDichDAODB dao;
    
        @Before
        public void setUp() {
            dao = new DeleteGiaoDichDAODB();
            // Thiết lập cơ sở dữ liệu giả lập nếu cần
        }
    
        @Test
        public void testDeleteGiaoDich_Success() {
            String maGiaoDich = "GD001"; // Giả lập mã giao dịch tồn tại
            assertTrue(dao.deleteGiaoDich(maGiaoDich));
        }
    
        @Test
        public void testDeleteGiaoDich_Failure() {
            String maGiaoDich = "GD999"; // Giả lập mã giao dịch không tồn tại
            assertFalse(dao.deleteGiaoDich(maGiaoDich));
        }
    }
    
    