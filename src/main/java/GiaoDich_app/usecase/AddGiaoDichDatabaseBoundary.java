package GiaoDich_app.usecase;

import GiaoDich_app.entity.GiaoDich;

public interface AddGiaoDichDatabaseBoundary {
    int addGiaoDich(GiaoDich giaoDich);
    GiaoDich findGiaoDichById(int id);
}
