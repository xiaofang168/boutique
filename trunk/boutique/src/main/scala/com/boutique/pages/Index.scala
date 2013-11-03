package com.boutique.pages

import org.apache.tapestry5.annotations.Import
import org.apache.tapestry5.ioc.annotations.Inject
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.Asset
import org.apache.tapestry5.annotations.Path

@Import(
  stylesheet = Array[String](
    "classpath:/assets/css/bootstrap.css",
    "classpath:/assets/css/style.css",
    "classpath:/assets/css/bootstrap-responsive.css"
  )
)
class Index {
  @Inject
  @Property
  @Path("classpath:assets/images/slider1.png")
  private var slider1: Asset = _
  
  @Inject
  @Property
  @Path("classpath:assets/images/slider2.png")
  private var slider2: Asset = _
  
  @Inject
  @Property
  @Path("classpath:assets/images/slider3.png")
  private var slider3: Asset = _
  
}