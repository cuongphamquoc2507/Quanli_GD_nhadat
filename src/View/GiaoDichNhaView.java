/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.NhaDao;
import Dao.GiaoDichNhaDao;
import Data.DataValdator;
import Data.DatabaseHelper;
import Data.ImageHelper;
import Data.MessageDialogHelper;
import Model.GiaoDichNha;
import Model.Nha;

import java.awt.Image;
import java.io.File;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 54321
 */
public class GiaoDichNhaView extends javax.swing.JPanel {
    private List<Nha> nha;
    private List<GiaoDichNha> gdnha;
    private MenuView menuView;
    private DefaultTableModel tblModel = new DefaultTableModel();
    private DefaultTableModel tblModel1 = new DefaultTableModel();
    private byte[] personalImage;

    /**
     * Creates new form GiaoDichNhaView
     */
    public GiaoDichNhaView() throws Exception {

        initComponents();
        initTable();
        LoaiNha();
        TrangThai();
        initCombobox();
        LoadDataTable();
        initTable1();
        LoadDataTable1();
        initCombobox1();
        initCombobox2();
        txtNgayGD.setDateFormatString("yyyy-MM-dd");
    }

    private void initCombobox() throws Exception {

        String sql = "SELECT MaKH FROM KhachHang";
        {
            Connection con = DatabaseHelper.openConnection();

            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            cbbMaKH.removeAllItems();
            while (rs.next()) {
                cbbMaKH.addItem(rs.getString("MaKH"));
            }
            rs.close();
            pstmt.close();
            con.close();
        }
    }

    private void initCombobox1() throws Exception {

        String sql = "SELECT MaNha from NHA";
        {
            Connection con = DatabaseHelper.openConnection();

            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            cbbMaNha.removeAllItems();
            while (rs.next()) {
                cbbMaNha.addItem(rs.getString("MaNha"));
            }
            rs.close();
            pstmt.close();
            con.close();
        }

    }

    private void initCombobox2() throws Exception {

        String sql = "SELECT MaND from NGUOIDUNG";
        {
            Connection con = DatabaseHelper.openConnection();

            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            cbbNguoiTao.removeAllItems();
            while (rs.next()) {
                cbbNguoiTao.addItem(rs.getString("MaND"));
            }
            rs.close();
            pstmt.close();
            con.close();
        }

    }

    private void LoaiNha() {
        String[] LoaiNha = new String[]{
            "Cao cấp", "Thông thường"
        };
        DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>(LoaiNha);
        this.cbbLoaiNha.setModel(boxModel);
    }

    private void TrangThai() {
        String[] TrangThai = new String[]{
            "Đã bán", "Chưa bán"
        };
        DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>(TrangThai);
        this.cbbTrangThai.setModel(boxModel);
    }

    private void LoadDataTable1() {
        try {
            NhaDao dao = new NhaDao();
            List<Nha> list = dao.findAll();
            tblModel1.setRowCount(0);
            for (Nha it : list) {
                tblModel1.addRow(new Object[]{
                    it.getMaNha(), it.getLoaiNha(), it.getDonGia(),
                    it.getDienTich(), it.getDiaChi(),
                    it.getTrangThai()
                });
            }
            tblModel1.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }
    // ten bnsg

    private void initTable1() {
        tblModel1 = new DefaultTableModel();
        String[] columns = new String[]{"Mã nhà", "Loai Nhà ", "Đơn Giá", "Diện tích ", "Địa chỉ", "Trạng thái"};
        tblModel1.setColumnIdentifiers(columns);
        tblbang2.setModel(tblModel1);

    }

    private void LoadDataTable() {
        try {
            GiaoDichNhaDao dao = new GiaoDichNhaDao();
            List<GiaoDichNha> list = dao.findAll();
            tblModel.setRowCount(0);
            for (GiaoDichNha it : list) {
                tblModel.addRow(new Object[]{
                    it.getMaGDN(), it.getNgayGD(), it.getMaNha(),
                    it.getMaKH(),it.getMaND(), it.getThanhToan()
                });
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }
    // ten bnsg

    private void initTable() {
        tblModel = new DefaultTableModel();
        String[] columns = new String[]{"Mã GD", "Ngay GD", "Mã nhà", "Khách hàng", "Người tạo", "Thành Tiền"};
        tblModel.setColumnIdentifiers(columns);
        tblbang1.setModel(tblModel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaNha = new javax.swing.JTextField();
        cbbLoaiNha = new javax.swing.JComboBox<>();
        txtDonGia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDiaChi = new javax.swing.JTextArea();
        pnlanh = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtDienTich = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        cbbTrangThai = new javax.swing.JComboBox<>();
        btnhinh1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblanh = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbang2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        txtTimKiem2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btntimkiem = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnThemXuat2 = new javax.swing.JButton();
        btnSuaXuat2 = new javax.swing.JButton();
        btnResetXuat2 = new javax.swing.JButton();
        btnXoaXuat2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMaGD = new javax.swing.JTextField();
        cbbMaNha = new javax.swing.JComboBox<>();
        cbbMaKH = new javax.swing.JComboBox<>();
        cbbNguoiTao = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtloainha1 = new javax.swing.JTextField();
        txtdongia1 = new javax.swing.JTextField();
        txtdientich1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lbltien = new javax.swing.JLabel();
        txt_Price1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnthanhtoan = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtNgayGD = new org.netbeans.modules.form.InvalidComponent();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblbang1 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        btnThemXuat3 = new javax.swing.JButton();
        btnSuaXuat3 = new javax.swing.JButton();
        btnResetXuat3 = new javax.swing.JButton();
        btnXoaXuat3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        txtTimNgay = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btntimkiem1 = new javax.swing.JButton();
        lblanh11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jPanel2.setLayout(null);

        jLabel1.setText("Mã Nhà");

        jLabel2.setText("Loại Nhà");

        jLabel3.setText("Đơn Giá");

        jLabel4.setText("Địa Chỉ");

        txtMaNha.setEditable(false);

        cbbLoaiNha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDonGia.setEditable(false);

        txaDiaChi.setColumns(20);
        txaDiaChi.setRows(5);
        jScrollPane1.setViewportView(txaDiaChi);

        javax.swing.GroupLayout pnlanhLayout = new javax.swing.GroupLayout(pnlanh);
        pnlanh.setLayout(pnlanhLayout);
        pnlanhLayout.setHorizontalGroup(
            pnlanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );
        pnlanhLayout.setVerticalGroup(
            pnlanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jLabel20.setText("Diện Tích");

        jLabel21.setText("Trạng Thái");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnhinh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/open-file-icon-16.png"))); // NOI18N
        btnhinh1.setText("Mở Hình");
        btnhinh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhinh1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setText("VNĐ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
        jLabel22.setText("m2");

        lblanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/image1s.png"))); // NOI18N
        lblanh.setBorder(new javax.swing.border.MatteBorder(null));
        lblanh.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblanhAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(253, 253, 253))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(cbbLoaiNha, 0, 210, Short.MAX_VALUE)
                                .addComponent(txtMaNha)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22))
                            .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator4)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnhinh1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbLoaiNha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnhinh1)
                    .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 80, 420, 450);

        tblbang2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblbang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbang2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblbang2);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Danh sách các loại nhà");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(500, 90, 700, 310);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(153, 0, 153))); // NOI18N
        jPanel17.setForeground(new java.awt.Color(0, 255, 153));

        txtTimKiem2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiem2KeyReleased(evt);
            }
        });

        jLabel8.setText("Tỉnh/ Thành phố");

        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search-icon-24.png"))); // NOI18N
        btntimkiem.setText("Tìm Kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btntimkiem)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel17);
        jPanel17.setBounds(10, 0, 610, 70);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        btnThemXuat2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemXuat2.setForeground(new java.awt.Color(0, 153, 0));
        btnThemXuat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThemXuat2.setText("Thêm");
        btnThemXuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemXuat2ActionPerformed(evt);
            }
        });

        btnSuaXuat2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuaXuat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-document-edit-icon-16.png"))); // NOI18N
        btnSuaXuat2.setText("Sửa");
        btnSuaXuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaXuat2ActionPerformed(evt);
            }
        });

        btnResetXuat2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResetXuat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_refresh_15px.png"))); // NOI18N
        btnResetXuat2.setText("Reset");
        btnResetXuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetXuat2ActionPerformed(evt);
            }
        });

        btnXoaXuat2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaXuat2.setForeground(new java.awt.Color(204, 0, 0));
        btnXoaXuat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-edit-delete-icon-16.png"))); // NOI18N
        btnXoaXuat2.setText("Xóa");
        btnXoaXuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaXuat2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemXuat2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btnSuaXuat2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnXoaXuat2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnResetXuat2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemXuat2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaXuat2)
                    .addComponent(btnResetXuat2)
                    .addComponent(btnXoaXuat2))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel8);
        jPanel8.setBounds(510, 410, 620, 80);

        jTabbedPane1.addTab("Danh Mục Nhà", jPanel2);

        jLabel7.setText("Mã Giao Dịch");

        jLabel9.setText("Ngày Giao Dịch");

        jLabel10.setText("Mã Nhà");

        jLabel12.setText("Khách Hàng");

        jLabel14.setText("Người Tạo");

        txtMaGD.setEditable(false);

        cbbMaNha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaNha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbbMaNhaFocusLost(evt);
            }
        });
        cbbMaNha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaNhaActionPerformed(evt);
            }
        });

        cbbMaKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaKHActionPerformed(evt);
            }
        });

        cbbNguoiTao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Loại Nhà");

        jLabel11.setText("Đơn Gía");

        jLabel15.setText("Diện Tích");

        txtloainha1.setEditable(false);

        txtdongia1.setEditable(false);
        txtdongia1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdongia1FocusLost(evt);
            }
        });

        txtdientich1.setEditable(false);
        txtdientich1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdientich1FocusLost(evt);
            }
        });

        lbltien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltien.setForeground(new java.awt.Color(255, 102, 102));
        lbltien.setText("1000000");

        txt_Price1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Price1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Price1.setText("VNĐ");
        txt_Price1.setBorder(null);
        txt_Price1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Price1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_money_25px.png"))); // NOI18N
        jLabel17.setText("Thanh Toán");

        btnthanhtoan.setText("Thanh Toán");
        btnthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthanhtoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnthanhtoan)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbltien, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Price1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Price1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnthanhtoan)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 51));
        jLabel23.setText("VNĐ");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 51));
        jLabel24.setText("m2");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMaNha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtloainha1)
                            .addComponent(cbbNguoiTao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtdientich1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdongia1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addGap(52, 52, 52))
                            .addComponent(cbbMaKH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNgayGD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(txtMaGD, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 19, Short.MAX_VALUE)))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtNgayGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMaNha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtloainha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtdongia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtdientich1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        tblbang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblbang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbang1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblbang1);

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        btnThemXuat3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemXuat3.setForeground(new java.awt.Color(0, 153, 0));
        btnThemXuat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThemXuat3.setText("Thêm");
        btnThemXuat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemXuat3ActionPerformed(evt);
            }
        });

        btnSuaXuat3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuaXuat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-document-edit-icon-16.png"))); // NOI18N
        btnSuaXuat3.setText("Sửa");
        btnSuaXuat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaXuat3ActionPerformed(evt);
            }
        });

        btnResetXuat3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResetXuat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_refresh_15px.png"))); // NOI18N
        btnResetXuat3.setText("Reset");
        btnResetXuat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetXuat3ActionPerformed(evt);
            }
        });

        btnXoaXuat3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaXuat3.setForeground(new java.awt.Color(204, 0, 0));
        btnXoaXuat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-edit-delete-icon-16.png"))); // NOI18N
        btnXoaXuat3.setText("Xóa");
        btnXoaXuat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaXuat3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnResetXuat3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemXuat3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSuaXuat3, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(btnXoaXuat3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaXuat3)
                    .addComponent(btnThemXuat3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetXuat3)
                    .addComponent(btnXoaXuat3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tải xuốn1.png"))); // NOI18N
        lbl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(153, 0, 153))); // NOI18N

        txtTimNgay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimNgayKeyReleased(evt);
            }
        });

        jLabel19.setText("Ngày Giao Dịch");

        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setText("In HĐ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btntimkiem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search-icon-24.png"))); // NOI18N
        btntimkiem1.setText("Tìm Kiếm");
        btntimkiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btntimkiem1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntimkiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimNgay)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Danh sách giao dich");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1215, 1215, 1215)
                        .addComponent(lblanh11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(117, 117, 117)
                .addComponent(lblanh11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Giao Dịch Nhà", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1257, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaXuat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaXuat2ActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValdator.CheckDL(txtMaNha, sb, "Mã nhà không được để trống !");

        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }
        if (MessageDialogHelper.showConfirmDialog(menuView, "Bạn có muốn xóa mã nhà này không", "Hỏi?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            NhaDao dao = new NhaDao();
            if (dao.delete(txtMaNha.getText())) {
                MessageDialogHelper.showMessageDialog(menuView, "Mã nhà đã đươc xóa!", "Thông báo !");

                LoadDataTable1();
            } else {
                MessageDialogHelper.showConfirmDialog(menuView, "Mã nhà không được xóa !", "Cảnh báo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btnXoaXuat2ActionPerformed

    private void btnResetXuat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetXuat2ActionPerformed
        txtMaNha.setText("");
        cbbLoaiNha.setSelectedItem("");
        txtDonGia.setText("");
        txaDiaChi.setText("");
        txtDienTich.setText("");
        cbbTrangThai.setSelectedItem("");
        LoadDataTable1();
    }//GEN-LAST:event_btnResetXuat2ActionPerformed

    private void btnSuaXuat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaXuat2ActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValdator.CheckDL(txtMaNha, sb, "Mã nhà không được để trống !");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }
        if (MessageDialogHelper.showConfirmDialog(menuView, "Bạn có muốn cập nhật nhà không", "Hỏi?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            Nha d = new Nha();
            d.setMaNha(Integer.parseInt(txtMaNha.getText()));
            d.setLoaiNha(cbbLoaiNha.getSelectedItem().toString());
            //d.setDonGia(Float.parseFloat(txtDonGia.getText()));
            d.setDienTich(Float.parseFloat(txtDienTich.getText()));
            d.setDiaChi(txaDiaChi.getText());
            d.setTrangThai(cbbTrangThai.getSelectedItem().toString());
            d.setMota(personalImage);

            NhaDao dao = new NhaDao();
            if (dao.update(d)) {
                MessageDialogHelper.showMessageDialog(menuView, "Mã nhà đã đươc cập nhật!", "Thông báo !");
                LoadDataTable1();
            } else {
                MessageDialogHelper.showConfirmDialog(menuView, "Mã nhà không được cập nhật do lỗi !", "Cảnh báo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btnSuaXuat2ActionPerformed

    private void btnThemXuat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemXuat2ActionPerformed
        StringBuilder sb = new StringBuilder();
//        DataValdator.CheckDL(txtMaNha, sb, "Mã đất không được để trống !");

        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }
        try {
            Nha d = new Nha();
//            d.setMaNha(Integer.parseInt(txtMaNha.getText()));
            d.setLoaiNha(cbbLoaiNha.getSelectedItem().toString());
            // d.setDonGia(Float.parseFloat(txtDonGia.getText()));
            d.setDienTich(Float.parseFloat(txtDienTich.getText()));
            d.setDiaChi(txaDiaChi.getText());
            d.setTrangThai(cbbTrangThai.getSelectedItem().toString());
            d.setMota(personalImage);

            cbbMaNhaFocusLost(null);
            NhaDao dao = new NhaDao();
            if (dao.insert(d)) {
                MessageDialogHelper.showMessageDialog(menuView, "Nhà đã đươc lưu", "Thông báo !");
                LoadDataTable1();
            } else {
                MessageDialogHelper.showConfirmDialog(menuView, "Nhà không được lưu do lỗi !", "Cảnh báo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btnThemXuat2ActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
       
       String tim=txtTimKiem2.getText();
       if(tim.length()>0){
           try{
               nha=new NhaDao().findDiaChi(tim);
           }catch(Exception e){
               e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
           }
           tblModel1.setRowCount(0);
            for (Nha it : nha) {
                tblModel1.addRow(new Object[]{
                    tblbang2.getRowCount()+1,
                    it.getMaNha(), it.getLoaiNha(), it.getDonGia(),
                    it.getDienTich(), it.getDiaChi(),
                    it.getTrangThai()
                });
            }
            tblModel1.fireTableDataChanged();
       }
       
      
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void txtTimKiem2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiem2KeyReleased

    }//GEN-LAST:event_txtTimKiem2KeyReleased

    private void tblbang2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbang2MouseClicked
        try {
            int row = tblbang2.getSelectedRow();
            if (row >= 0) {
                Integer id = (Integer) tblbang2.getValueAt(row, 0);
                NhaDao dao = new NhaDao();
                Nha sv = dao.findNha(id);
                
                if (sv != null) {
                    txtMaNha.setText("" +sv.getMaNha());
                    cbbLoaiNha.setSelectedItem(sv.getLoaiNha());
                    txtDonGia.setText("" + sv.getDonGia());
                    txtDienTich.setText("" + sv.getDienTich());
                    txaDiaChi.setText(sv.getDiaChi());
                    cbbTrangThai.setSelectedItem(sv.getTrangThai());
                    if (sv.getMota() != null) {
                        Image img = ImageHelper.createiImage(sv.getMota(), "jpg");
                        lblanh.setIcon(new ImageIcon(img));
                        personalImage = sv.getMota();
                    } else {
                        personalImage = sv.getMota();
                        ImageIcon icon = new ImageIcon(
                                getClass().getResource(""));
                        lblanh.setIcon(icon);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_tblbang2MouseClicked

    private void txt_Price1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Price1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Price1ActionPerformed

    private void btntimkiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiem1ActionPerformed
         String tim2=txtTimNgay.getText();
       if(tim2.length()>0){
           try{
               gdnha=new GiaoDichNhaDao().findbyDate(tim2);
           }catch(Exception e){
               e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
           }
           tblModel.setRowCount(0);
            for (GiaoDichNha it : gdnha) {
                tblModel.addRow(new Object[]{
                    it.getMaGDN(), it.getNgayGD(), it.getMaNha(),
                    it.getMaKH(),it.getMaND(), it.getThanhToan()
                });
            }
            tblModel.fireTableDataChanged();
       }
    }//GEN-LAST:event_btntimkiem1ActionPerformed

            
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTimNgayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimNgayKeyReleased

    }//GEN-LAST:event_txtTimNgayKeyReleased

    private void tblbang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbang1MouseClicked
        try {
            int row = tblbang1.getSelectedRow();
            if (row >= 0) {
                Integer id = (Integer) tblbang1.getValueAt(row, 0);

                GiaoDichNhaDao dao = new GiaoDichNhaDao();
                GiaoDichNha sv = dao.findNha(id);
                if (sv != null) {
                    txtMaGD.setText("" +sv.getMaGDN());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    txtNgayGD.setDate(sdf.parse(sv.getNgayGD()));
                    cbbMaNha.setSelectedItem(sv.getMaNha());
                    cbbMaKH.setSelectedItem(sv.getMaKH());
                    cbbNguoiTao.setSelectedItem(sv.getMaND());
                    lbltien.setText(String.format("%.2f", sv.getThanhToan()));
//                    lbltien.setText(" " + sv.getThanhToan());
                    cbbMaNhaFocusLost(null);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_tblbang1MouseClicked

    private void btnXoaXuat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaXuat3ActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValdator.CheckDL(txtMaGD, sb, "Mã giao dich không được để trống !");

        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }
        if (MessageDialogHelper.showConfirmDialog(menuView, "Bạn có muốn xóa giao dich không", "Hỏi?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            GiaoDichNhaDao dao = new GiaoDichNhaDao();
            if (dao.delete(Integer.parseInt(txtMaGD.getText()))) {
                MessageDialogHelper.showMessageDialog(menuView, "Giao Dich đã đươc xóa!", "Thông báo !");

                LoadDataTable();
            } else {
                MessageDialogHelper.showConfirmDialog(menuView, "Giao dịch không được xóa !", "Cảnh báo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btnXoaXuat3ActionPerformed

    private void btnResetXuat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetXuat3ActionPerformed
        txtMaGD.setText("");
        cbbMaNha.setSelectedItem("");
        txtdongia1.setText("");
        txtdientich1.setText("");
        txtloainha1.setText("");
        cbbMaKH.setSelectedItem("");
        cbbNguoiTao.setSelectedItem("");

        lbltien.setText("");
        LoadDataTable();
    }//GEN-LAST:event_btnResetXuat3ActionPerformed

    private void btnSuaXuat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaXuat3ActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValdator.CheckDL(txtMaGD, sb, "Mã giao dich không được để trống !");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }
        if (MessageDialogHelper.showConfirmDialog(menuView, "Bạn có muốn cập nhật giao dich không", "Hỏi?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            GiaoDichNha d = new GiaoDichNha();
            d.setMaGDN(Integer.parseInt(txtMaGD.getText()));
            SimpleDateFormat sf;
            sf = new SimpleDateFormat("yyyy-MM-dd");
            d.setNgayGD(sf.format(txtNgayGD.getDate()));
            d.setMaNha(cbbMaNha.getSelectedItem().toString());
            d.setMaKH(cbbMaKH.getSelectedItem().toString());
            d.setMaND(cbbNguoiTao.getSelectedItem().toString());
            d.setThanhToan(Float.parseFloat(lbltien.getText()));
            cbbMaNhaFocusLost(null);
            GiaoDichNhaDao dao = new GiaoDichNhaDao();
            if (dao.update(d)) {
                MessageDialogHelper.showMessageDialog(menuView, "Ma giao dich đã đươc cập nhật!", "Thông báo !");
                LoadDataTable();
            } else {
                MessageDialogHelper.showConfirmDialog(menuView, "Ma giao dich không được cập nhật do lỗi !", "Cảnh báo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btnSuaXuat3ActionPerformed

    private void btnThemXuat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemXuat3ActionPerformed
        StringBuilder sb = new StringBuilder();
//        DataValdator.CheckDL(txtMaGD, sb, "Mã giao dich không được để trống !");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }
        try {
            GiaoDichNha d = new GiaoDichNha();
//            d.setMaGDN(Integer.parseInt(txtMaGD.getText()));
            SimpleDateFormat sf;
            sf = new SimpleDateFormat("yyyy-MM-dd");
            d.setNgayGD(sf.format(txtNgayGD.getDate()));
            d.setMaNha(cbbMaNha.getSelectedItem().toString());
            d.setMaKH(cbbMaKH.getSelectedItem().toString());
            d.setMaND(cbbNguoiTao.getSelectedItem().toString());
            d.setThanhToan(Float.parseFloat(lbltien.getText()));
            
            cbbMaNhaFocusLost(null);
            GiaoDichNhaDao dao = new GiaoDichNhaDao();
            if (dao.insert(d)) {
                MessageDialogHelper.showMessageDialog(menuView, "Giao dich đã đươc lưu", "Thông báo !");
                LoadDataTable();
            } else {
                MessageDialogHelper.showConfirmDialog(menuView, "Giao Dich không được lưu do lỗi !", "Cảnh báo!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btnThemXuat3ActionPerformed

    private void cbbMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMaKHActionPerformed

    private void btnhinh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhinh1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return " Image File (*.jpg)";
            }
        });
        // hop thoai
        if (chooser.showOpenDialog(menuView) == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File file = chooser.getSelectedFile();
        try {
            ImageIcon icon = new ImageIcon(file.getPath());
            Image img = ImageHelper.resize(icon.getImage(), 250, 160);
            ImageIcon resiIcon = new ImageIcon(img);
            lblanh.setIcon(resiIcon);
            //luu vao CSDL
            personalImage = ImageHelper.toByteArray(img, "jpg");
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(menuView, e.getMessage(), "Lỗi!");
        }
    }//GEN-LAST:event_btnhinh1ActionPerformed

    private void lblanhAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblanhAncestorAdded

    }//GEN-LAST:event_lblanhAncestorAdded

    private void cbbMaNhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbbMaNhaFocusLost
        try {
            NhaDao dao = new NhaDao();
            Nha d = dao.findNha(Integer.parseInt(cbbMaNha.getSelectedItem().toString()));
            if (d != null) {
                txtloainha1.setText(d.getLoaiNha());
                txtdongia1.setText(" " + d.getDonGia());
                txtdientich1.setText(" " + d.getDienTich());
                if (d.getMota() != null) {
                    Image img = ImageHelper.createiImage(d.getMota(), "jpg");
                    lbl1.setIcon(new ImageIcon(img));
                    personalImage = d.getMota();
                } else {
                    personalImage = d.getMota();
                    ImageIcon icon = new ImageIcon(
                            getClass().getResource(""));
                    lbl1.setIcon(icon);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbbMaNhaFocusLost

    private void txtdientich1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdientich1FocusLost
        
    }//GEN-LAST:event_txtdientich1FocusLost

    private void txtdongia1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdongia1FocusLost
        if (txtdientich1.getText().equals("")
                || txtdongia1.getText().equals("")
                || txtloainha1.getText().equals("")) {
            return;
        }

        float s = Float.parseFloat(txtdientich1.getText());
        float gia = Float.parseFloat(txtdongia1.getText());
        String l = (txtloainha1.getText());
        if ("Cao cấp".equals(l)) {
            float thanhtien = (float) (s * gia);
            String st = String.format("%.2f", thanhtien);
            lbltien.setText(st);
        } else {
            float thanhtien = (float) (s * gia * 0.9);
            String st = String.format("%.2f", thanhtien);
            lbltien.setText(st);
        }
    }//GEN-LAST:event_txtdongia1FocusLost

    private void btnthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthanhtoanActionPerformed
        if (txtdientich1.getText().equals("")
                || txtdongia1.getText().equals("")
                || txtloainha1.getText().equals("")) {
            return;
        }

        float s = Float.parseFloat(txtdientich1.getText());
        float gia = Float.parseFloat(txtdongia1.getText());
        String l = (txtloainha1.toString());
        if ("Cao cấp".equals(l)) {
            float thanhtien = (float) (s * gia * 0.9);
            String st = String.format("%.2f", thanhtien);
            lbltien.setText(st);
        } else {
            float thanhtien = (float) (s * gia);
            String st = String.format("%.2f", thanhtien);
            lbltien.setText(st);
        }
    }//GEN-LAST:event_btnthanhtoanActionPerformed

    private void cbbMaNhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaNhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMaNhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResetXuat2;
    private javax.swing.JButton btnResetXuat3;
    private javax.swing.JButton btnSuaXuat2;
    private javax.swing.JButton btnSuaXuat3;
    private javax.swing.JButton btnThemXuat2;
    private javax.swing.JButton btnThemXuat3;
    private javax.swing.JButton btnXoaXuat2;
    private javax.swing.JButton btnXoaXuat3;
    private javax.swing.JButton btnhinh1;
    private javax.swing.JButton btnthanhtoan;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btntimkiem1;
    private javax.swing.JComboBox<String> cbbLoaiNha;
    private javax.swing.JComboBox<String> cbbMaKH;
    private javax.swing.JComboBox<String> cbbMaNha;
    private javax.swing.JComboBox<String> cbbNguoiTao;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lblanh;
    private javax.swing.JLabel lblanh11;
    private javax.swing.JLabel lbltien;
    private javax.swing.JPanel pnlanh;
    private javax.swing.JTable tblbang1;
    private javax.swing.JTable tblbang2;
    private javax.swing.JTextArea txaDiaChi;
    private javax.swing.JFormattedTextField txtDienTich;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaGD;
    private javax.swing.JTextField txtMaNha;
    private org.netbeans.modules.form.InvalidComponent txtNgayGD;
    private javax.swing.JTextField txtTimKiem2;
    private javax.swing.JTextField txtTimNgay;
    private javax.swing.JTextField txt_Price1;
    private javax.swing.JTextField txtdientich1;
    private javax.swing.JTextField txtdongia1;
    private javax.swing.JTextField txtloainha1;
    // End of variables declaration//GEN-END:variables

    
}
