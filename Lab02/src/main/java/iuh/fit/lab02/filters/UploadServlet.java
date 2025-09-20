//package iuh.fit.lab02.filters;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.MultipartConfig;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.Part;
//
//@WebServlet("/upload")
//@MultipartConfig(
//        fileSizeThreshold = 1024 * 1024,     // 1 MB
//        maxFileSize = 1024 * 1024 * 10,      // 10 MB
//        maxRequestSize = 1024 * 1024 * 50    // 50 MB
//)
//public class UploadServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    private static final String UPLOAD_DIR = "uploads";
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        // Lấy đường dẫn thực tế trên server
//        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
//
//        // Tạo thư mục nếu chưa có
//        File uploadDir = new File(uploadPath);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdir();
//        }
//
//        // Duyệt qua các part (file) từ form
//        for (Part part : request.getParts()) {
//            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
//            if (fileName != null && !fileName.isEmpty()) {
//                String filePath = uploadPath + File.separator + fileName;
//                try (InputStream input = part.getInputStream()) {
//                    Files.copy(input, new File(filePath).toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
//                }
//            }
//        }
//
//        // Trả về kết quả
//        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().println("<h3>Upload thành công!</h3>");
//        response.getWriter().println("<a href='upload.jsp'>Quay lại</a>");
//    }
//}