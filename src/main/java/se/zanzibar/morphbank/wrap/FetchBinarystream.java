package se.zanzibar.morphbank.wrap;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A RESTful-wrapper around the Morphank-API
 *
 * @version 0.1
 *
 * @author ingimar
 */
@Path("/media")

public class FetchBinarystream {

    private final String BASE_IMAGE_URI = "http://images.morphbank.net/";

    private final String BASE_WWW_URI = "http://www.morphbank.net/";

    /**
     * Wrapping: http://images.morphbank.net/?id=735451&imgType=jpg
     *
     * @param morphbankID
     * @return
     */
    @GET
    @Path("/stream/{morphbankID}")
    @Produces("image/jpg")
    public Response getDefaultJPEG_Media(@PathParam("morphbankID") String morphbankID) {
        final String baseURI = BASE_IMAGE_URI;
        String id = "?id=".concat(morphbankID);
        String type = "&imgType=jpg";

        String uri = baseURI.concat(id).concat(type);
        URI location = null;
        try {
            location = new URI(uri);
        } catch (URISyntaxException ex) {
            Logger.getLogger(FetchBinarystream.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }

    /**
     * Wrapping:
     * http://images.morphbank.net/Image/viewFrame.php?id=735451&width=800&height=600
     *
     * @param morphbankID
     * @param width
     * @param height
     * @return
     */
    @GET
    @Path("/stream/{morphbankID}/{width}/{height}")
    @Produces("image/jpg")
    public Response getDefaultJPEG_MediaDimension(
            @PathParam("morphbankID") String morphbankID,
            @PathParam("width") String width,
            @PathParam("height") String height) {
        final String baseURI = BASE_IMAGE_URI.concat("Image/viewFrame.php");
        String id = "?id=".concat(morphbankID);
        String dWidth = "&width=".concat(width);
        String dHeight = "&height=".concat(height);

        String uri = baseURI.concat(id).concat(dWidth).concat(dHeight);
        URI location = null;
        try {
            location = new URI(uri);
        } catch (URISyntaxException ex) {
            Logger.getLogger(FetchBinarystream.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }

    /**
     * Wrapping:
     * http://images.morphbank.net/imageSizes.php?id=735451&imgType=jpg
     *
     * @param morphbankID
     * @param mime
     * @return '84595+400+301+jpg'
     */
    @GET
    @Path("/metadata/{morphbankID}/{mime}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTypedMetadata(
            @PathParam("morphbankID") String morphbankID,
            @PathParam("mime") String mime) {
        final String baseURI = BASE_IMAGE_URI.concat("imageSizes.php");
        String id = "?id=".concat(morphbankID);
        String type = "&imgType=".concat(mime);

        String uri = baseURI.concat(id).concat(type);
        URI location = null;
        try {
            location = new URI(uri);
        } catch (URISyntaxException ex) {
            Logger.getLogger(FetchBinarystream.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }

    /**
     * Wrapping : http://www.morphbank.net/checkImageAuthorization.php?728053
     *
     * @param morphbankID
     * @return 'true [morphbankID]' || 'false'
     */
    @GET
    @Path("/authorization/{morphbankID}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response checkAuthorization(
            @PathParam("morphbankID") String morphbankID) {
        final String baseURI = BASE_WWW_URI.concat("checkImageAuthorization.php");
        String id = "?id=".concat(morphbankID);

        String uri = baseURI.concat(id);
        URI location = null;
        try {
            location = new URI(uri);
        } catch (URISyntaxException ex) {
            Logger.getLogger(FetchBinarystream.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }

    /**
     * Variation : Wrapping: http://images.morphbank.net/?id=735451&imgType=jpg
     *
     * @param morphbankID
     * @param mime
     * @return
     */
    @GET
    @Path("/stream/{morphbankID}/{mime}")
    public Response getExplicitType_Media(@PathParam("morphbankID") String morphbankID, @PathParam("mime") String mime) {
        final String baseURI = "http://images.morphbank.net/";
        String id = "?id=".concat(morphbankID);
        String type = "&imgType=".concat(mime);

        String uri = baseURI.concat(id).concat(type);
        URI location = null;
        try {
            location = new URI(uri);
        } catch (URISyntaxException ex) {
            Logger.getLogger(FetchBinarystream.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }
}
