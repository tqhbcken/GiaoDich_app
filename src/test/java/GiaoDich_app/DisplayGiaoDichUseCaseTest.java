package GiaoDich_app;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import GiaoDich_app.usecase.DisplayGiaoDichDatabaseBoundary;
import GiaoDich_app.usecase.DisplayGiaoDichOutputBoundary;
import GiaoDich_app.usecase.DisplayGiaoDichUseCase;
import GiaoDich_app.usecase.dto.DisplayGiaoDichOutputDTO;

public class DisplayGiaoDichUseCaseTest {

    @Mock
    private DisplayGiaoDichDatabaseBoundary databaseBoundary;
    @Mock
    private DisplayGiaoDichOutputBoundary outputBoundary;
    @InjectMocks
    private DisplayGiaoDichUseCase displayGiaoDichUseCase;

    // @Before
    // public void setUp() {
    //     MockitoAnnotations.openMocks(this);
    // }
    @Test
    public void testExecute_shouldDisplayGiaoDichData() {
        // Arrange
        DisplayGiaoDichOutputDTO dto1 = new DisplayGiaoDichOutputDTO();
        dto1.setMaGiaoDich(1);
        dto1.setNgayGiaoDich(Date.valueOf("2024-11-13"));
        dto1.setDonGia(5000000);
        dto1.setDienTich(100);
        dto1.setLoaiGiaoDich("Nhà");

        DisplayGiaoDichOutputDTO dto2 = new DisplayGiaoDichOutputDTO();
        dto2.setMaGiaoDich(2);
        dto2.setNgayGiaoDich(Date.valueOf("2024-11-14"));
        dto2.setDonGia(3000000);
        dto2.setDienTich(50);
        dto2.setLoaiGiaoDich("Đất");

        List<DisplayGiaoDichOutputDTO> giaoDichList = Arrays.asList(dto1, dto2);

        when(databaseBoundary.getAllGiaoDich()).thenReturn(giaoDichList);

        // Act
        displayGiaoDichUseCase.execute();

        // Assert
        verify(outputBoundary).present(giaoDichList);
    }

    @Test
    public void testExecute_shouldHandleEmptyList() {
        // Arrange
        List<DisplayGiaoDichOutputDTO> giaoDichList = Arrays.asList();
        when(databaseBoundary.getAllGiaoDich()).thenReturn(giaoDichList);

        // Act
        displayGiaoDichUseCase.execute();

        // Assert
        verify(outputBoundary).present(giaoDichList);
    }

    @Test
    public void testExecute_shouldHandleException() {
        // Arrange
        when(databaseBoundary.getAllGiaoDich()).thenThrow(new RuntimeException("Database error"));

        // Act
        displayGiaoDichUseCase.execute();

        // Assert
        verify(outputBoundary).showError(any());
    }
}
