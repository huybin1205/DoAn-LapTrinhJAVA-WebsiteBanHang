<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%= constants.Constants.STORE_NAME %>: CONTACT</title>
        <jsp:include page="layout/script-header.jsp"></jsp:include>
    </head>
        <body class="animsition">

            <!--Header-->
        <jsp:include page="layout/header.jsp"></jsp:include>

            <!-- Sidebar -->
        <jsp:include page="layout/slidebar.jsp"></jsp:include>


            <!-- Cart -->
        <jsp:include page="layout/cart.jsp"></jsp:include>

            <!--Banner--> 
        <jsp:include page="layout/banner-contact.jsp"></jsp:include>

            <!--Contact-->
            <section class="bg0 p-t-104 p-b-116">
                <div class="container">
                    <div class="flex-w flex-tr">
                        <div class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md">
                            <form>
                                <h4 class="mtext-105 cl2 txt-center p-b-30">
                                    Send Us A Message
                                </h4>

                                <div class="bor8 m-b-20 how-pos4-parent">
                                    <input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" name="email" placeholder="Your Email Address">
                                    <img class="how-pos4 pointer-none" src="images/icons/icon-email.png" alt="ICON">
                                </div>

                                <div class="bor8 m-b-30">
                                    <textarea class="stext-111 cl2 plh3 size-120 p-lr-28 p-tb-25" name="msg" placeholder="How Can We Help?"></textarea>
                                </div>

                                <button class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">
                                    Submit
                                </button>
                            </form>
                        </div>

                        <div class="size-210 bor10 flex-w flex-col-m p-lr-93 p-tb-30 p-lr-15-lg w-full-md">
                            <div class="flex-w w-full p-b-42">
                                <span class="fs-18 cl5 txt-center size-211">
                                    <span class="lnr lnr-map-marker"></span>
                                </span>

                                <div class="size-212 p-t-2">
                                    <span class="mtext-110 cl2">
                                        Address
                                    </span>

                                    <p class="stext-115 cl6 size-213 p-t-18">
                                        Coza Store Center 8th floor, 379 Hudson St, New York, NY 10018 US
                                    </p>
                                </div>
                            </div>

                            <div class="flex-w w-full p-b-42">
                                <span class="fs-18 cl5 txt-center size-211">
                                    <span class="lnr lnr-phone-handset"></span>
                                </span>

                                <div class="size-212 p-t-2">
                                    <span class="mtext-110 cl2">
                                        Lets Talk
                                    </span>

                                    <p class="stext-115 cl1 size-213 p-t-18">
                                        +1 800 1236879
                                    </p>
                                </div>
                            </div>

                            <div class="flex-w w-full">
                                <span class="fs-18 cl5 txt-center size-211">
                                    <span class="lnr lnr-envelope"></span>
                                </span>

                                <div class="size-212 p-t-2">
                                    <span class="mtext-110 cl2">
                                        Sale Support
                                    </span>

                                    <p class="stext-115 cl1 size-213 p-t-18">
                                        contact@example.com
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--</section>-->	


                <!-- Map -->
                <div class="map">
                    <div class="size-303" id="map">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.120335130718!2d106.71240001405666!3d10.802094592304117!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528a459cb43ab%3A0x6c3d29d370b52a7e!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBIdXRlY2g!5e0!3m2!1svi!2s!4v1554117234885!5m2!1svi!2s" width="100%" height="500" frameborder="0" style="border:0" allowfullscreen></iframe>
                    </div>
                    <!--<div class="size-303" id="google_map" data-map-x="40.691446" data-map-y="-73.886787" data-pin="images/icons/pin.png" data-scrollwhell="0" data-draggable="1" data-zoom="11"></div>-->
                </div>

            </div>
        </div>

    <jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>
