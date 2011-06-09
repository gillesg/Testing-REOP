package jetbrains.sample.extensions.pageExtension;

import javax.servlet.http.HttpServletRequest;
import jetbrains.buildServer.web.openapi.PagePlaces;
import jetbrains.buildServer.web.openapi.PlaceId;
import jetbrains.buildServer.web.openapi.SimplePageExtension;
import jetbrains.buildServer.web.util.WebUtil;
import org.jetbrains.annotations.NotNull;

/**
 * @author Yegor.Yarko
 *         Date: 11.03.2009
 */
public class PageExtension extends SimplePageExtension {
  public PageExtension(PagePlaces pagePlaces) {
    super(pagePlaces, PlaceId.ALL_PAGES_FOOTER, "samplePlugin", "input.jsp");
    register();
  }

  @Override
  public boolean isAvailable(@NotNull final HttpServletRequest request) {
    return WebUtil.getPathWithoutAuthenticationType(request).startsWith("/overview.html");
  }
}
